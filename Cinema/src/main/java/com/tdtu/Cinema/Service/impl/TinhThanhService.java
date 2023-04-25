package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.TinhThanhEntity;
import com.tdtu.Cinema.Repository.TinhThanhRepository;
import com.tdtu.Cinema.Service.ITinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TinhThanhService implements ITinhThanhService {

    @Autowired
    private TinhThanhRepository tinhThanhRepository;
    @Override
    public List<TinhThanhEntity> getall() {
        return tinhThanhRepository.findAll();
    }

    @Override
    public TinhThanhEntity getOneById(Long id) {
        return tinhThanhRepository.findById(id).get();
    }
}
