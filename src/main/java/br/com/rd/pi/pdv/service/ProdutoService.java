package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import br.com.rd.pi.pdv.model.entity.ProdutoEntity;
import br.com.rd.pi.pdv.repository.LmpmItemRepository;
import br.com.rd.pi.pdv.repository.LmpmRepository;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import br.com.rd.pi.pdv.service.bo.LmpmItemBO;
import br.com.rd.pi.pdv.service.bo.ProdutoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private LmpmItemRepository lmpmItemRepository;

    @Autowired
    private LmpmRepository lmpmRepository;

    @Autowired
    private ProdutoBO produtoBO;

    @Autowired
    private LmpmItemBO lmpmItemBO;

    @PersistenceContext
    private EntityManager em;

    public ProdutoEntity buscarProdutoId(Long codigo){

        return repository.getOne(codigo);
    }

    public LmpmItemEntity buscarProdutoLmpmId (Long codigoProduto){
        return lmpmItemRepository.findByProdutoAndLmpm(repository.getOne(codigoProduto),lmpmRepository.getOne(codigoProduto));
    }

    public List <LmpmItemEntity> teste (Long codigoProduto){

        return em.createNamedQuery("buscarProdutoLmpm", LmpmItemEntity.class).setParameter("produto", codigoProduto).getResultList();
    }

}
