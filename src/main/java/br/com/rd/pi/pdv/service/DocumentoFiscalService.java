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
    private RecargaBO recargaBO;

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private OperacaoBO operacaoBO;

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RecargaService recargaService;

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
        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        if (dto.getCliente().getIdCliente() != null){
            ClienteEntity cliente = clienteRepository.getOne(dto.getCliente().getIdCliente()); // pegando o cliente do dto recebido do front
            docEntity.setCliente(cliente);
        }

        FilialEntity filial = filialRepository.getOne(dto.getFilial().getCdFilial()); // msm coisa so que com a filial
        OperacaoEntity operacao = operacaoRepository.getOne(dto.getOperacao().getCdOperacao());

        docEntity.setFilial(filial);
        docEntity.setOperacao(operacao);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();

        for(DocumentoItemDTO itemDTO : dto.getItens()){

            DocumentoItemEntity itemEntity = new DocumentoItemEntity();
            itemEntity.setQtdItem(itemDTO.getQtdItem());
            itemEntity.setNumItemDoc(itemDTO.getNumItemDoc());
            itemEntity.setProduto(produtoRepository.getOne(itemDTO.getProduto().getCdProduto()));
            itemEntity.setValorItem(itemDTO.getValorItem());

            itemEntity.setDocumentoFiscal(docEntity);
            itemsEntity.add(itemEntity);
        }
        docEntity.setItens(itemsEntity);


        docEntity.setPagamentos((pagamentos(dto.getPagamentos(), docEntity)));

        repository.save(docEntity);

    }

    public void inserirVendaRecarga(DocumentoFiscalDTO dto){

        FilialEntity filial = filialRepository.getOne(dto.getFilial().getCdFilial());
        OperacaoEntity operacao = operacaoRepository.getOne(dto.getOperacao().getCdOperacao());
        RecargaEntity recarga = recargaBO.parseToEntity(dto.getRecarga(),null);

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setRecarga(recarga);
        docEntity.setFilial(filial);
        docEntity.setOperacao(operacao);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        docEntity.setPagamentos((pagamentos(dto.getPagamentos(), docEntity)));

        repository.save(docEntity);
    }

    private List<PagamentoDocEntity> pagamentos (List<PagamentoDocDTO> pagamentosDTOS, DocumentoFiscalEntity docEntity){

        List<PagamentoDocEntity> pagamentosEntities = new ArrayList<>();

        for(PagamentoDocDTO pagamentoDocDTO : pagamentosDTOS){

            PagamentoDocEntity pagamentoDocEntity = new PagamentoDocEntity();
            pagamentoDocEntity.setVlPagamento(pagamentoDocDTO.getVlPagamento());
            pagamentoDocEntity.setTipoPagamento(tipoPagamentoRepository.getOne(pagamentoDocDTO.getTipoPagamento().getIdTipoPagamento()));

            pagamentoDocEntity.setDocumentoFiscal(docEntity);
            pagamentosEntities.add(pagamentoDocEntity);
        }

        return pagamentosEntities;
    }

}
