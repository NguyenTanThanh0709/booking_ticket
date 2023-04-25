package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBanEntity, Long> {
}
