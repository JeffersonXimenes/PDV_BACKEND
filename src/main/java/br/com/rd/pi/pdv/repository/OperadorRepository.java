package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.OperadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<OperadorEntity, Long> {

}
