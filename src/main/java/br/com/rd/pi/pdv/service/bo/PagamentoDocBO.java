package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import br.com.rd.pi.pdv.repository.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDocBO {

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;


    public static PagamentoDocDTO parseToDTO(PagamentoDocEntity entity) {
        PagamentoDocDTO dto = new PagamentoDocDTO();

        if(entity == null) {
            return dto;
        }

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        dto.setIdPagamento(entity.getIdPagamento());
        dto.setVlPagamento(entity.getVlPagamento());
        dto.setIdTipoPagamento(entity.getTipoPagamento().getIdTipoPagamento());

        return dto;
    }

    public PagamentoDocEntity parseToEntity(PagamentoDocDTO dto, PagamentoDocEntity entity) {

        if (entity == null) {
            entity = new PagamentoDocEntity();
        }
        if (dto == null) {
            return entity;
        }
        entity.setIdDocumentoFiscal(dto.getIdDocumentoFiscal());
        entity.setIdPagamento(dto.getIdPagamento());
        entity.setVlPagamento(dto.getVlPagamento());
        entity.setTipoPagamento(tipoPagamentoRepository.getOne(dto.getIdTipoPagamento()));

        return entity;
    }

}