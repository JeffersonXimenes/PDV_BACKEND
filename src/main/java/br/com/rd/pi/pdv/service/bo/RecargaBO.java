package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import br.com.rd.pi.pdv.repository.OperadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecargaBO {

    @Autowired
    private OperadoraRepository operadoraRepository;

    public RecargaDTO parseToDTO(RecargaEntity entity){
        RecargaDTO dto = new RecargaDTO();

        if(entity == null )
            return dto;
        dto.setIdRecarga(entity.getIdRecarga());
        dto.setNumeroTelefone(entity.getNumeroTelefone());
        dto.setIdOperadora(entity.getOperadora().getIdOperadora());
        //dto.setIdTipoPagamento(entity.getTipoPagamento().getIdTipoPagamento());

        //dto.setIdOperadora(entity.getIdRecarga());
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

        entity.setOperadora(operadoraRepository.getOne(dto.getIdOperadora()));

        entity.setValorRecarga(dto.getValorRecarga());

        return entity;
    }
}
