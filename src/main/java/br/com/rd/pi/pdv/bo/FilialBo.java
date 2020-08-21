package br.com.rd.pi.pdv.bo;

import br.com.rd.pi.pdv.model.dto.FilialDTO;
import br.com.rd.pi.pdv.model.entity.FilialEntity;

public class FilialBo {
    public FilialDTO parseToDTO(FilialEntity entity){
        FilialDTO dto = new FilialDTO();
        if (entity == null)
            return dto;
        dto.setCdFilial(entity.getCdFilial());
        dto.setCnpj(entity.getCnpj());
        dto.setNmFilial(entity.getNmFilial());
        dto.setNrTelefone(entity.getNrTelefone());
        return dto;

    }

    public FilialEntity parseToEntity(FilialDTO dto, FilialEntity entity){
        if (entity == null)
            entity = new FilialEntity();
        if (dto == null)
            return entity;
        entity.setCdFilial(dto.getCdFilial());
        entity.setCnpj(dto.getCnpj());
        entity.setNmFilial(dto.getNmFilial());
        entity.setNrTelefone((dto.getNrTelefone()));
        return entity;


    }






}




