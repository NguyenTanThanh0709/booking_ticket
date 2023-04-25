package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.DanhGiaPhimEntity;
import com.tdtu.Cinema.Entity.DanhGiaPhimId;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Repository.DanhGiaPhimRepository;
import com.tdtu.Cinema.Service.IDanhGiaPhimService;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DanhGiaPhimService implements IDanhGiaPhimService {
    @Autowired
    private DanhGiaPhimRepository danhGiaPhimRepository;

    @Autowired
    private IPhimService phimService;
    @Override
    public DanhGiaPhimEntity save(DanhGiaPhimEntity danhGiaPhimEntity) {
        return danhGiaPhimRepository.save(danhGiaPhimEntity);
    }

    @Override
    public List<DanhGiaPhimEntity> getDanhGiaPhimByPhim(Long idphim) {
        PhimEntity phim = phimService.findOneById(idphim);
        return danhGiaPhimRepository.findByPhimEntity(phim);

    }

    @Override
    public List<DanhGiaPhimEntity> getall() {
        return danhGiaPhimRepository.findAll();
    }

    @Override
    public void delete(DanhGiaPhimId id) {
         danhGiaPhimRepository.deleteById(id);
    }
}
