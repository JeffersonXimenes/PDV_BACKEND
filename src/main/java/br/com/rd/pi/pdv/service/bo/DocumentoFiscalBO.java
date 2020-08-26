package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoItemEntity;
import br.com.rd.pi.pdv.repository.ClienteRepository;
import br.com.rd.pi.pdv.repository.FilialRepository;
import br.com.rd.pi.pdv.repository.RecargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentoFiscalBO {

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private DocumentoItemBO documentoItemBO;

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private RecargaBO recargaBO;

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity entity){
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());

        if(entity.getFilial() != null){
            dto.setFilial(filialBO.parseToDTO(entity.getFilial()));
        }

        dto.setCliente(clienteBO.parseToDTO(entity.getCliente()));
        dto.setDataAbertura(entity.getDataAbertura());
        dto.setDataFechamento(entity.getDataFechamento());
        dto.setFlagNota(entity.getFlagNota());
        dto.setValorDocumento(entity.getValorDocumento());
        dto.setNumeroCaixa(entity.getNumeroCaixa());

        return dto;
    }

    public DocumentoFiscalDTO parseToDTOVenda (DocumentoFiscalEntity entity){
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        dto.setFilial(filialBO.parseToDTO(entity.getFilial()));
        dto.setNumeroCaixa(entity.getNumeroCaixa());


        if(entity.getCliente() != null)
            dto.setCliente(clienteBO.parseToDTO(entity.getCliente()));

        dto.setFlagNota(entity.getFlagNota());

        dto.setValorDocumento(entity.getValorDocumento());

        return dto;
    }

    public DocumentoFiscalDTO parseToDTORecarga (DocumentoFiscalEntity entity){
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        dto.setFilial(filialBO.parseToDTO(entity.getFilial()));
        dto.setNumeroCaixa(entity.getNumeroCaixa());
        dto.setValorDocumento(entity.getValorDocumento());
        dto.setRecarga(recargaBO.parseToDTO(entity.getRecarga()));
        dto.setFlagNota(entity.getFlagNota());

        return dto;
    }


    public DocumentoFiscalEntity parseToEntity(DocumentoFiscalEntity entity, DocumentoFiscalDTO dto){

        if(entity == null)
            entity = new DocumentoFiscalEntity();
        if(dto == null)
            return entity;

        entity.setIdDocumentoFiscal(dto.getIdDocumentoFiscal());
        entity.setFilial(filialRepository.getOne(dto.getFilial().getCdFilial()));
        entity.setCliente(clienteRepository.getOne(dto.getCliente().getIdCliente()));
        entity.setRecarga(recargaRepository.getOne(dto.getRecarga().getIdRecarga()));
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setDataFechamento(dto.getDataFechamento());
        entity.setFlagNota(dto.getFlagNota());
        entity.setValorDocumento(dto.getValorDocumento());
        entity.setNumeroCaixa(dto.getNumeroCaixa());

        List <DocumentoItemEntity> entidadeItem  = new ArrayList <>();

        for (DocumentoItemDTO itemDTO: dto.getItens()) {
            entidadeItem.add(documentoItemBO.parseToEntity(itemDTO,null));

        }
        entity.setItens(entidadeItem);

        return entity;
    }
}
