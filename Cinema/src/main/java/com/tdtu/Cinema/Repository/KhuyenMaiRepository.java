package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMaiEntity,Long> {
}
