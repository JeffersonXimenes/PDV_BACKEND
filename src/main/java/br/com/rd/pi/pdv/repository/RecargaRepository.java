package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.OperadoraEntity;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecargaRepository extends JpaRepository<RecargaEntity, Long> {
    List<RecargaEntity> findByOperadora(OperadoraEntity operadora);
}