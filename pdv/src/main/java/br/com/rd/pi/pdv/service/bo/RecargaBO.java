package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import org.springframework.stereotype.Component;

@Component
public class RecargaBO {

    public RecargaDTO parseToDTO(RecargaEntity entity){
        RecargaDTO dto = new RecargaDTO();

        if(entity == null )
            return dto;
        dto.setIdRecarga(entity.getIdRecarga());
        dto.setNumeroTelefone(entity.getNumeroTelefone());
        dto.setIdOperadora(entity.getIdOperadora());
        dto.setValorRecarga(entity.getValorRecarga());

        return dto;
    }


    public RecargaEntity parseToEntity(RecargaDTO dto, RecargaEntity entity){
        if(entity == null)
            entity  = new RecargaEntity();

        if(dto == null)
            return entity;
        entity.setIdRecarga(dto.getIdRecarga());
        entity.setNumeroTelefone(dto.getNumeroTelefone());
        entity.setIdOperadora(dto.getIdOperadora());
        entity.setValorRecarga(dto.getValorRecarga());

        return entity;
    }
}
