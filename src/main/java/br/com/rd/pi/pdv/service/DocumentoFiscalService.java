package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.*;
import br.com.rd.pi.pdv.repository.*;
import br.com.rd.pi.pdv.service.bo.DocumentoFiscalBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<DocumentoFiscalDTO> buscarTodosDoc(){
        List <DocumentoFiscalDTO> listaDocumento = new ArrayList<>();

        for (DocumentoFiscalEntity entity: repository.findAll()) {
            DocumentoFiscalDTO dto = documentoFiscalBO.parseToDTO(entity);
            listaDocumento.add(dto);
        }
        return listaDocumento;
    }

    public void inserirVendaNormal(DocumentoFiscalDTO dto){
        ClienteEntity cliente = clienteRepository.getOne(dto.getIdCliente());
        FilialEntity filial = filialRepository.getOne(dto.getCdFilial());

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setCliente(cliente);
        docEntity.setCdFilial(filial);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        List<DocumentoItemEntity> itemsEntity = new ArrayList<>();

        for(DocumentoItemDTO itemDTO : dto.getItens()){

            DocumentoItemEntity itemEntity = new DocumentoItemEntity();

            itemEntity.setNumItemDoc(itemDTO.getNumItemDoc());
            itemEntity.setCdProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
            itemEntity.setValorItem(itemDTO.getValorItem());

            itemEntity.setDocumentoFiscal(docEntity);
            itemsEntity.add(itemEntity);
        }

        docEntity.setItens(itemsEntity);

        repository.save(docEntity);

    }

    public void inserirVendaRecarga(DocumentoFiscalDTO dto){
        FilialEntity filial = filialRepository.getOne(dto.getCdFilial());
        RecargaEntity recarga = recargaRepository.getOne(dto.getIdRecarga());

        DocumentoFiscalEntity docEntity= new DocumentoFiscalEntity();

        docEntity.setRecarga(recarga);
        docEntity.setCdFilial(filial);

        docEntity.setValorDocumento(dto.getValorDocumento());
        docEntity.setFlagNota(dto.getFlagNota());
        docEntity.setNumeroCaixa(dto.getNumeroCaixa());

        repository.save(docEntity);

    }
}