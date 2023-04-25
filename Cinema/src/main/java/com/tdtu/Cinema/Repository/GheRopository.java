package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.GheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheRopository extends JpaRepository<GheEntity, Long> {
}
