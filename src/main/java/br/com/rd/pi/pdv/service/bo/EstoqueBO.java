package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.EstoqueDTO;
import br.com.rd.pi.pdv.model.entity.EstoqueEntity;
import br.com.rd.pi.pdv.repository.FilialRepository;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueBO {

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private ProdutoBO produtoBO;


    public EstoqueDTO parseToDTO(EstoqueEntity estoqueEntity) {

        EstoqueDTO dto = new EstoqueDTO();

        dto.setCdEstoque(estoqueEntity.getCdEstoque());
        dto.setQtEmpenho(estoqueEntity.getQtdEmpenho());
        dto.setQtEstoque(estoqueEntity.getQtdEstoque());
        dto.setProduto(produtoBO.parseToDTO(estoqueEntity.getProduto()));
        dto.setFilial(filialBO.parseToDTO(estoqueEntity.getFilial()));

        return  dto;
    }
    public EstoqueEntity parseToEntity(EstoqueDTO estoqueDto){

        EstoqueEntity entity = new EstoqueEntity();

        entity.setCdEstoque(estoqueDto.getCdEstoque());
        entity.setQtdEmpenho(estoqueDto.getQtEmpenho());
        entity.setQtdEstoque(estoqueDto.getQtEstoque());
        entity.setProduto(produtoBO.parseToEntity(estoqueDto.getProduto(),null));
        entity.setFilial(filialBO.parseToEntity(estoqueDto.getFilial(), null));

        return entity;
    }
}
