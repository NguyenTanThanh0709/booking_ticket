package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IPhimService {


    Page<PhimEntity> Page(int start, int end);
    List<PhimEntity> findAll();
    PhimEntity findOneById(Long id);
    List<PhimEntity> findByTheLoai(String theloai);
    List<PhimEntity> findByLoaiphim(String theloai);
    List<PhimEntity> findByTenphimContaining(String tenphim);
    List<PhimEntity> findByDotuoi(int tuoi);
    PhimEntity save(PhimDTO phim);
    PhimEntity update(PhimDTO phim);
    List<PhimEntity> findByTrangthai(String trangthai);

}
