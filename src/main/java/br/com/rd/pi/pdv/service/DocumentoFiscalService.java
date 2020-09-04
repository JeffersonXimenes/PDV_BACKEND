package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.model.entity.*;
import br.com.rd.pi.pdv.repository.*;
import br.com.rd.pi.pdv.service.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoFiscalService {

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DocumentoFiscalBO documentoFiscalBO;

    @Autowired
    private DocumentoItemBO documentoItemBO;

    @Autowired
    private RecargaBO recargaBO;

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private OperacaoBO operacaoBO;

    @Autowired
    private PagamentoDocBO pagamentoDocBO;

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    private EstoqueService estoqueService;

    @PersistenceContext
    private EntityManager em;

    public List<DocumentoFiscalDTO> buscarTodosDoc(){

        List <DocumentoFiscalDTO> listaDocumento = new ArrayList<>();

        Long idOperacao = 1L; // se nao me engano op 1 seria o de venda
        for (DocumentoFiscalEntity entity: em.createNamedQuery("buscarNotaPorOperacao", DocumentoFiscalEntity.class).setParameter("operacao", idOperacao).getResultList()) {
            DocumentoFiscalDTO dto = documentoFiscalBO.parseToDTO(entity);
            listaDocumento.add(dto);
        }
        return listaDocumento;
    }

    public DocumentoFiscalDTO buscarDocId (Long idDocFiscal){
        return documentoFiscalBO.parseToDTO(repository.getOne(idDocFiscal));
    }

    public void inserirVendaNormal(DocumentoFiscalDTO dto){
        DocumentoFiscalEntity docEntity = documentoFiscalBO.parseToEntity(null, dto);

        if (dto.getCliente().getIdCliente() != null){
            ClienteEntity cliente = clienteRepository.getOne(dto.getCliente().getIdCliente()); // pegando o cliente do dto recebido do front
            docEntity.setCliente(cliente);
        }

        FilialEntity filial = filialRepository.getOne(dto.getFilial().getCdFilial()); // msm coisa so que com a filial
        OperacaoEntity operacao = operacaoRepository.getOne(dto.getOperacao().getCdOperacao());

        docEntity.setFilial(filial);
        docEntity.setOperacao(operacao);

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();

        for(DocumentoItemDTO itemDTO : dto.getItens()){

            DocumentoItemEntity itemEntity = documentoItemBO.parseToEntity(itemDTO,null);
            itemEntity.setDocumentoFiscal(docEntity);

            itemsEntity.add(itemEntity);

        }
        docEntity.setItens(itemsEntity);

        docEntity.setPagamentos((pagamentos(dto.getPagamentos(), docEntity)));

        repository.save(docEntity);

        estoqueService.atualizaEstoqueVenda(dto);
    }

    public void inserirVendaRecarga(DocumentoFiscalDTO dto){

        FilialEntity filial = filialRepository.getOne(dto.getFilial().getCdFilial());
        OperacaoEntity operacao = operacaoRepository.getOne(dto.getOperacao().getCdOperacao());
        RecargaEntity recarga = recargaBO.parseToEntity(dto.getRecarga(),null);

        DocumentoFiscalEntity docEntity= documentoFiscalBO.parseToEntity(null, dto);

        docEntity.setRecarga(recarga);
        docEntity.setFilial(filial);
        docEntity.setOperacao(operacao);

        docEntity.setPagamentos((pagamentos(dto.getPagamentos(), docEntity)));

        repository.save(docEntity);
    }

    private List<PagamentoDocEntity> pagamentos (List<PagamentoDocDTO> pagamentosDTOS, DocumentoFiscalEntity docEntity){

        List<PagamentoDocEntity> pagamentosEntities = new ArrayList<>();

        for(PagamentoDocDTO pagamentoDocDTO : pagamentosDTOS){

            PagamentoDocEntity pagamentoDocEntity = pagamentoDocBO.parseToEntity(pagamentoDocDTO,null);
            pagamentoDocEntity.setDocumentoFiscal(docEntity);
            pagamentosEntities.add(pagamentoDocEntity);
        }

        return pagamentosEntities;
    }

    // INSERI ISSO AQUI
    public void inserirDataAbertura (DocumentoFiscalDTO dto) {
        FilialEntity filial = filialBO.parseToEntity(dto.getFilial(),null);
        OperacaoEntity operacao = operacaoBO.parseToEntity(dto.getOperacao(),null);
        DocumentoFiscalEntity dataAbertura = new DocumentoFiscalEntity();

        java.util.Date data = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(data.getTime());

        dataAbertura.setFilial(filial);
        dataAbertura.setOperacao(operacao);
        dataAbertura.setDataAbertura(dataSql);
        repository.save(dataAbertura);
    }

}
