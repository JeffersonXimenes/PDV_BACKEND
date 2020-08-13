package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.OperadorDTO;
import br.com.rd.pi.pdv.model.entity.OperadorEntity;
import org.springframework.stereotype.Component;

@Component
public class OperadorBO {

    public OperadorDTO parseToDTO(OperadorEntity entity){
        OperadorDTO dto = new OperadorDTO();

        if(entity == null)
            return dto;

        dto.setIdOperador(entity.getIdOperador());
        dto.setNumeroMatricula(entity.getNumeroMatricula());
        dto.setNomeOperador(entity.getNomeOperador());
        dto.setDescricaoCargo(entity.getDescricaoCargo());

        return dto;
    }

    public OperadorEntity parseToEntity(OperadorDTO dto, OperadorEntity entity){
        if (entity == null)
            entity = new OperadorEntity();

        if (dto == null)
            return entity;

        entity.setIdOperador(dto.getIdOperador());
        entity.setNumeroMatricula(dto.getNumeroMatricula());
        entity.setNomeOperador(dto.getNomeOperador());
        entity.setDescricaoCargo(dto.getDescricaoCargo());

        return entity;
    }
}
