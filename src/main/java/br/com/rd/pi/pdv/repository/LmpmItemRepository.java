package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.LmpmEntity;
import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import br.com.rd.pi.pdv.model.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LmpmItemRepository  extends JpaRepository<LmpmItemEntity, Long> {
    LmpmItemEntity findByProdutoAndLmpm (ProdutoEntity produto, LmpmEntity lmpm);


}
