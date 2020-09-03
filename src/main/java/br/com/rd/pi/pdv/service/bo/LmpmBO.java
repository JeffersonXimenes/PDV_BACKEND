package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.LmpmDTO;
import br.com.rd.pi.pdv.model.entity.LmpmEntity;
import org.springframework.stereotype.Component;

@Component
public class LmpmBO {

    public LmpmDTO parseToDto(LmpmEntity entity){
        LmpmDTO dto = new LmpmDTO();

        if(entity == null)
            return dto;

        dto.setDtInicioLmpm(entity.getDtInicioLmpm());
        dto.setDtFimLmpm(entity.getDtFimLmpm());

        return dto;
    }



}
