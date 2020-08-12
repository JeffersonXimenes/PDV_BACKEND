package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.OperacaoDTO;
import br.com.rd.pi.pdv.model.entity.OperacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class OperacaoBO {

    public OperacaoDTO parseToDTO(OperacaoEntity entity){
        OperacaoDTO dto = new OperacaoDTO();

        if(entity == null)
            return dto;

        dto.setCdOperacao(entity.getCdOperacao());
        dto.setIdTipoOperacao(entity.getIdTipoOperacao());
        dto.setDescricaoOperacao(entity.getDescricaoOperacao());

        return dto;
    }

    public OperacaoEntity parseToEntity(OperacaoDTO dto, OperacaoEntity entity){
        if (entity == null)
            entity = new OperacaoEntity();

        if (dto == null)
            return entity;

        entity.setCdOperacao(dto.getCdOperacao());
        entity.setIdTipoOperacao(dto.getIdTipoOperacao());
        entity.setDescricaoOperacao(dto.getDescricaoOperacao());

        return entity;
    }
}
