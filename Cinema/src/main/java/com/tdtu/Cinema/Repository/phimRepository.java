package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.PhimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface phimRepository extends JpaRepository<PhimEntity, Long> {
    List<PhimEntity> findByTuoiLessThan(int tuoi);
    List<PhimEntity> findByTheloai(String theloai);
    List<PhimEntity> findByTenphimContaining(String tenphim);
    List<PhimEntity> findByLoaiphim(String loadphim);
    List<PhimEntity> findByTrangthai(String trangthai);
}
