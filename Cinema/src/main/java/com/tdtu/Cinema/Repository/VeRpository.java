package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.VeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeRpository extends JpaRepository<VeEntity,Long> {
}
