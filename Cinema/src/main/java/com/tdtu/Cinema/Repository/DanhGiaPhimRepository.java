package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaPhimRepository extends JpaRepository<DanhGiaPhimEntity, DanhGiaPhimId> {
    @Query("SELECT t FROM DanhGiaPhimEntity t WHERE t.phim_danhgia_main = :phim")
    List<DanhGiaPhimEntity> findByPhimEntity(@Param("phim") PhimEntity phim);

}
