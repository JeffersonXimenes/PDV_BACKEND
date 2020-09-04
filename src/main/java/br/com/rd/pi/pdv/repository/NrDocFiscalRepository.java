package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.FilialEntity;
import br.com.rd.pi.pdv.model.entity.NrDocFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NrDocFiscalRepository extends JpaRepository <NrDocFiscalEntity, Long> {
}
