package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.TipoOperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOperacaoRepository extends JpaRepository<TipoOperacaoEntity, Long> {
}
