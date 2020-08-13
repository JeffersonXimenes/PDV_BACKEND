package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.OperadoraDTO;
import br.com.rd.pi.pdv.model.entity.OperadoraEntity;
import org.springframework.stereotype.Component;

@Component
public class OperadoraBO {

    public OperadoraDTO parseToDTO(OperadoraEntity entity){
        OperadoraDTO dto = new OperadoraDTO();

        if(entity == null)
            return dto;

        dto.setIdOperadora(entity.getIdOperadora());
        dto.setDescricaoOperadora(entity.getDescricaoOperadora());

        return dto;
    }

    public OperadoraEntity parseToEntity(OperadoraDTO dto){
        OperadoraEntity entity = new OperadoraEntity();

        if(dto == null)
            return entity;

        entity.setIdOperadora(dto.getIdOperadora());
        entity.setDescricaoOperadora(dto.getDescricaoOperadora());

        return entity;
    }
}
