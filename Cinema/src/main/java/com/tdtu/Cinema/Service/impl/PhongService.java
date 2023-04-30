package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.PhongChieuEntity;
import com.tdtu.Cinema.Repository.PhongRepository;
import com.tdtu.Cinema.Service.IPhongSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhongService implements IPhongSerivce {
    @Autowired
    private PhongRepository phongRepository;
    @Override
    public List<PhongChieuEntity> getAll() {
        return phongRepository.findAll();
    }

    @Override
    public PhongChieuEntity getone(Long id) {
        return phongRepository.findById(id).get();
    }
}
