package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
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

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private RecargaService recargaService;

    public List<DocumentoFiscalDTO> buscarTodosDoc(){

        List <DocumentoFiscalDTO> listaDocumento = new ArrayList<>();

        Long idOperacao = 2L; // se nao me engano op 2 seria o de venda
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
        ClienteEntity cliente = clienteBO.parseToEntity(dto.getCliente(),null); // pegando o cliente do dto recebido do front
        FilialEntity filial = filialBO.parseToEntity(dto.getFilial(),null); // msm coisa so que com a filial
        OperacaoEntity operacao = operacaoBO.parseToEntity(dto.getOperacao(),null);

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setCliente(cliente);
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

        repository.save(docEntity);

    }

    public void inserirVendaRecarga(DocumentoFiscalDTO dto){
        FilialEntity filial = filialBO.parseToEntity(dto.getFilial(),null);
        RecargaEntity recarga = recargaBO.parseToEntity(dto.getRecarga(),null);
        OperacaoEntity operacao = operacaoBO.parseToEntity(dto.getOperacao(),null);

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setRecarga(recarga);
        docEntity.setFilial(filial);
        docEntity.setOperacao(operacao);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        repository.save(docEntity);
    }
}
