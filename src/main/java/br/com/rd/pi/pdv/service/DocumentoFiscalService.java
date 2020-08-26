package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.*;
import br.com.rd.pi.pdv.repository.*;
import br.com.rd.pi.pdv.service.bo.ClienteBO;
import br.com.rd.pi.pdv.service.bo.DocumentoFiscalBO;
import br.com.rd.pi.pdv.service.bo.FilialBO;
import br.com.rd.pi.pdv.service.bo.RecargaBO;
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

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DocumentoItemService documentoItemService;

    public List<DocumentoFiscalDTO> buscarTodosDoc(){

        List <DocumentoFiscalDTO> listaDocumento = new ArrayList<>();

        Long idOperacao = 2L; // se nao me engano op 2 seria o de venda
        for (DocumentoFiscalEntity entity: em.createNamedQuery("buscarNotaPorOperacao", DocumentoFiscalEntity.class).setParameter("operacao", idOperacao).getResultList()) {
            DocumentoFiscalDTO dto = documentoFiscalBO.parseToDTO(entity);
            listaDocumento.add(dto);
        }
        return listaDocumento;
    }

    public void inserirVendaNormal(DocumentoFiscalDTO dto){
        ClienteEntity cliente = clienteBO.parseToEntity(dto.getCliente(),null); // pegando o cliente do dto recebido do front
        FilialEntity filial = filialBO.parseToEntity(dto.getFilial(),null); // msm coisa so que com a filial

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setCliente(cliente);
        docEntity.setFilial(filial);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();

        for(DocumentoItemDTO itemDTO : dto.getItens()){

            DocumentoItemEntity itemEntity = new DocumentoItemEntity();

            itemEntity.setNumItemDoc(itemDTO.getNumItemDoc());
            itemEntity.setProduto(produtoRepository.getOne(itemDTO.getProduto().getCdProduto()));
            itemEntity.setValorItem(itemDTO.getValorItem());

            itemEntity.setDocumentoFiscal(docEntity);
            itemsEntity.add(itemEntity);
        }

        docEntity.setItens(itemsEntity);

        if (cliente != null)
            clienteRepository.save(cliente);

        filialRepository.save(filial);

        repository.save(docEntity);


    }

    public void inserirVendaRecarga(DocumentoFiscalDTO dto){
        FilialEntity filial = filialBO.parseToEntity(dto.getFilial(),null);
        RecargaEntity recarga = recargaBO.parseToEntity(dto.getRecarga(),null);

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setRecarga(recarga);
        docEntity.setFilial(filial);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        recargaRepository.save(recarga);
        filialRepository.save(filial);

        repository.save(docEntity);

    }
}
