package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThanhToanRepository extends JpaRepository<ThanhToanEntity,Long> {
    @Query("SELECT t FROM ThanhToanEntity t WHERE t.user_thanhtoan = :user")
    List<ThanhToanEntity> findByUserThanhtoan(@Param("user") UserEnity user);
}
