package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import br.com.rd.pi.pdv.model.entity.ProdutoEntity;
import br.com.rd.pi.pdv.repository.LmpmItemRepository;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import br.com.rd.pi.pdv.service.bo.LmpmItemBO;
import br.com.rd.pi.pdv.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private LmpmItemRepository lmpmItemRepository;

    @Autowired
    private ProdutoBO produtoBO;

    @Autowired
    private LmpmItemBO lmpmItemBO;

    public ProdutoEntity buscarProdutoId(Long codigo){

        return repository.getOne(codigo);
    }

//    public LmpmItemEntity buscarProdutoLmpmId (Long codigo){
//
//        return
//    }

}
