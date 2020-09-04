package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.EstoqueEntity;
import br.com.rd.pi.pdv.model.entity.FilialEntity;
import br.com.rd.pi.pdv.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository <EstoqueEntity,Long> {

    EstoqueEntity findByProdutoAndFilial (ProdutoEntity produtoEntity, FilialEntity filialEntity);
}
