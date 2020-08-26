package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.model.entity.OperacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoFiscalRepository extends JpaRepository <DocumentoFiscalEntity, Long> {
    List<OperacaoEntity> findByOperacao(OperacaoEntity operacao);

}
