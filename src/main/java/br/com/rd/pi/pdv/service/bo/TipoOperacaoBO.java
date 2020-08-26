package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.TipoOperacaoDTO;
import br.com.rd.pi.pdv.model.entity.TipoOperacaoEntity;

public class TipoOperacaoBO {

    public TipoOperacaoDTO parseToDTO(TipoOperacaoEntity entity){
        TipoOperacaoDTO dto = new TipoOperacaoDTO();
        if (entity == null)
            return dto;
        dto.setIdTipoOperacao(entity.getIdTipoOperacao());
        dto.setDescricaoTipoOperacao(entity.getDescricaoTipoOperacao());
        return dto;
    }

}
