package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.TinhThanhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhThanhRepository extends JpaRepository<TinhThanhEntity, Long> {
}
