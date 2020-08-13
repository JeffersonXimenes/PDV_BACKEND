package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.ProdutoDTO;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import br.com.rd.pi.pdv.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoBO produtoBO;

    public ProdutoDTO buscarProdutoId(Long codigo){
        return produtoBO.parseToDTO(repository.getOne(codigo));
    }

}
