package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.DocumentoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoItemRepository extends JpaRepository<DocumentoItemEntity, Long> {
}
