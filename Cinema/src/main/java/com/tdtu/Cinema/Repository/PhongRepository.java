package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.PhongChieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongRepository extends JpaRepository<PhongChieuEntity, Long> {
}
