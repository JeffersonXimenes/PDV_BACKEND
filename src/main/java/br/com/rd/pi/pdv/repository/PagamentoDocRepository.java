package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import br.com.rd.pi.pdv.model.entity.TipoPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoDocRepository extends JpaRepository<PagamentoDocEntity, Long> {
    List<PagamentoDocEntity>FindByTipoPagamento(TipoPagamentoEntity tipoPagamento);

}