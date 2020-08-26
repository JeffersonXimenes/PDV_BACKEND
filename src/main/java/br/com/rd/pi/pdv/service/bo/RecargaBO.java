package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import br.com.rd.pi.pdv.repository.OperadoraRepository;


import br.com.rd.pi.pdv.repository.RecargaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecargaBO {

    @Autowired
    private OperadoraRepository operadoraRepository;

    @Autowired
    private OperadoraBO operadoraBO;

    public RecargaDTO parseToDTO(RecargaEntity entity){
        RecargaDTO dto = new RecargaDTO();

        if(entity == null )
            return dto;
        dto.setNumeroTelefone(entity.getNumeroTelefone());
        dto.setOperadora(operadoraBO.parseToDTO(entity.getOperadora()));
        dto.setValorRecarga(entity.getValorRecarga());

        return dto;
    }


    public RecargaEntity parseToEntity(RecargaDTO dto, RecargaEntity entity){
        if(entity == null)
            entity  = new RecargaEntity();

        if(dto == null)
            return entity;

        entity.setNumeroTelefone(dto.getNumeroTelefone());
        entity.setOperadora(operadoraRepository.getOne(dto.getOperadora().getIdOperadora()));
        entity.setValorRecarga(dto.getValorRecarga());

        return entity;
    }
}
