package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.TipoPagamentoDTO;
import br.com.rd.pi.pdv.model.entity.TipoPagamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoPagamentoBO {

    public TipoPagamentoDTO parseToDTO(TipoPagamentoEntity entity) {
        TipoPagamentoDTO dto = new TipoPagamentoDTO();

        if(entity == null) {
            return dto;
        }

        dto.setIdTipoPagamento(entity.getIdTipoPagamento());
        dto.setDsTipoPagamento(entity.getDsTipoPagamento());

        return dto;
    }

    public TipoPagamentoEntity parseToEntity(TipoPagamentoDTO dto, TipoPagamentoEntity entity) {
        if (entity == null) {
            entity = new TipoPagamentoEntity();
        }

        if (dto == null) {
            return entity;
        }

        entity.setIdTipoPagamento(dto.getIdTipoPagamento());
        entity.setDsTipoPagamento(dto.getDsTipoPagamento());

        return entity;
    }

}