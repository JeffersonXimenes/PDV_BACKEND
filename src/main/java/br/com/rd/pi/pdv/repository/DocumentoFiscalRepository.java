package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoFiscalRepository extends JpaRepository <DocumentoFiscalEntity, Long> {
}
