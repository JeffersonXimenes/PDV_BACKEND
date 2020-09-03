package br.com.rd.pi.pdv.repository;

import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmpmItemRepository  extends JpaRepository<LmpmItemEntity, Long> {
}
