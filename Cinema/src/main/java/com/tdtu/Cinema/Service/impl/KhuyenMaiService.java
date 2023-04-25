package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Repository.KhuyenMaiRepository;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class KhuyenMaiService implements IKhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;
    @Override
    public List<KhuyenMaiEntity> getall() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMaiEntity getone(Long id) {
        return khuyenMaiRepository.findById(id).get();
    }

    @Override
    public KhuyenMaiEntity save(KhuyenMaiEntity khuyenMaiEntity) {
        return  khuyenMaiRepository.save(khuyenMaiEntity);
    }
}
