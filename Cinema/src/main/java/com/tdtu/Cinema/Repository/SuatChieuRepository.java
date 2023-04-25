package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.SuatChieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuatChieuRepository extends JpaRepository<SuatChieuEntity,Long> {

}
