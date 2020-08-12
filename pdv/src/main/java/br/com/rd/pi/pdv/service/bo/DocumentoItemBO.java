package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoItemEntity;

public class DocumentoItemBO {

    public DocumentoItemDTO parseToDTO(DocumentoItemEntity entity){
        DocumentoItemDTO dto = new DocumentoItemDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumento(entity.getIdDocumento());
        dto.setNumItemDoc(entity.getNumItemDoc());
        dto.setCdProduto(entity.getCdProduto());
        dto.setQtdItem(entity.getQtdItem());
        dto.setValorItem(entity.getValorItem());
        dto.setPorcentoIcms(entity.getPorcentoIcms());
        dto.setValorIcms(entity.getValorIcms());

        return dto;
    }

    public DocumentoItemEntity parseToEntity(DocumentoItemDTO dto, DocumentoItemEntity entity){
        if (entity == null)
            entity = new DocumentoItemEntity();

        if (dto == null)
            return entity;

        entity.setIdDocumento(dto.getIdDocumento());
        entity.setNumItemDoc(dto.getNumItemDoc());
        entity.setCdProduto(dto.getCdProduto());
        entity.setQtdItem(dto.getQtdItem());
        entity.setValorItem(dto.getValorItem());
        entity.setPorcentoIcms(dto.getPorcentoIcms());
        entity.setValorIcms(dto.getValorIcms());

        return entity;
    }
}
