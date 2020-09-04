package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.EstoqueEntity;
import br.com.rd.pi.pdv.repository.EstoqueRepository;
import br.com.rd.pi.pdv.repository.FilialRepository;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import br.com.rd.pi.pdv.service.bo.EstoqueBO;
import br.com.rd.pi.pdv.service.bo.FilialBO;
import br.com.rd.pi.pdv.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private FilialBO filialBO;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private EstoqueBO estoqueBO;

    @Autowired
    private ProdutoBO produtoBO;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void atualizaEstoqueVenda (DocumentoFiscalDTO dto){

        for (DocumentoItemDTO itemDTO : dto.getItens()) {
            EstoqueEntity estoqueEntity = estoqueRepository.findByProdutoAndFilial(produtoBO.parseToEntity(itemDTO.getProduto(),null),
                    filialBO.parseToEntity(dto.getFilial(),null));

            estoqueEntity.setQtdEstoque(estoqueEntity.getQtdEstoque() - itemDTO.getQtdItem());
            estoqueRepository.save(estoqueEntity);
        }
    }

}
