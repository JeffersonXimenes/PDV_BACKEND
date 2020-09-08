package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import br.com.rd.pi.pdv.repository.DocumentoFiscalRepository;
import br.com.rd.pi.pdv.repository.TipoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDocBO {

    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    private TipoPagamentoBO tipoPagamentoBO;

    @Autowired
    private DocumentoFiscalBO documentoFiscalBO;

    @Autowired
    private DocumentoFiscalRepository documentoFiscalRepository;


    public PagamentoDocDTO parseToDTO(PagamentoDocEntity entity) {
        PagamentoDocDTO dto = new PagamentoDocDTO();

        if(entity == null) {
            return dto;
        }

        dto.setDocumentoFiscal(documentoFiscalBO.parseToDTO(entity.getDocumentoFiscal()));
        dto.setIdPagamento(entity.getIdPagamento());
        dto.setVlPagamento(entity.getVlPagamento());
        dto.setTipoPagamento(tipoPagamentoBO.parseToDTO(entity.getTipoPagamento()));

        return dto;
    }

    public PagamentoDocEntity parseToEntity(PagamentoDocDTO dto, PagamentoDocEntity entity) {

        if (entity == null) {
            entity = new PagamentoDocEntity();
        }
        if (dto == null) {
            return entity;
        }
        entity.setVlPagamento(dto.getVlPagamento());
        entity.setTipoPagamento(tipoPagamentoRepository.getOne(dto.getTipoPagamento().getIdTipoPagamento()));


        return entity;
    }

}