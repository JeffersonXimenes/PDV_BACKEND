package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.OperacaoDTO;
import br.com.rd.pi.pdv.model.entity.OperacaoEntity;
import br.com.rd.pi.pdv.repository.TipoOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperacaoBO {

    @Autowired
    private TipoOperacaoRepository tipoOpRepository;

    public OperacaoDTO parseToDTO(OperacaoEntity entity){
        OperacaoDTO dto = new OperacaoDTO();

        if(entity == null)
            return dto;

        dto.setCdOperacao(entity.getCdOperacao());
        dto.setTipoOperacao(entity.getTipoOperacao().getIdTipoOperacao());
        dto.setDescricaoOperacao(entity.getDescricaoOperacao());

        return dto;
    }

    public OperacaoEntity parseToEntity(OperacaoDTO dto, OperacaoEntity entity){
        if (entity == null)
            entity = new OperacaoEntity();

        if (dto == null)
            return entity;

        entity.setCdOperacao(dto.getCdOperacao());
        entity.setTipoOperacao(tipoOpRepository.getOne(dto.getTipoOperacao()));
        entity.setDescricaoOperacao(dto.getDescricaoOperacao());

        return entity;
    }
}
