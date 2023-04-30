package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.PhongChieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongRepository extends JpaRepository<PhongChieuEntity, Long> {
}
