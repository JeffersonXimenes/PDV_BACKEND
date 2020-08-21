package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.ProdutoDTO;
import br.com.rd.pi.pdv.model.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO {

    public ProdutoDTO parseToDTO(ProdutoEntity entity){
        ProdutoDTO dto = new ProdutoDTO();

        if(entity == null)
            return dto;

        dto.setCdProduto(entity.getCdProduto());
        dto.setValorProduto(entity.getValorProduto());
//        dto.setDescricaoProduto(entity.getDescricaoProduto());

        return dto;
    }

    public ProdutoEntity parseToEntity(ProdutoDTO dto, ProdutoEntity entity){
        if (entity == null)
            entity = new ProdutoEntity();

        if (dto == null)
            return entity;

        entity.setCdProduto(dto.getCdProduto());
        entity.setValorProduto(dto.getValorProduto());
        entity.setDescricaoProduto(dto.getDescricaoProduto());


        return entity;
    }

}
