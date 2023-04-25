package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.VeEntity;
import com.tdtu.Cinema.Repository.VeRpository;
import com.tdtu.Cinema.Service.IVeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VeService implements IVeService {

    @Autowired
    private VeRpository veRpository;

    @Override
    public List<VeEntity> getall() {
        return veRpository.findAll();
    }

    @Override
    public VeEntity getOneById(Long id) {
        return veRpository.findById(id).get();
    }

    @Override
    public VeEntity save(VeEntity veEntity) {
        return veRpository.save(veEntity);
    }
}
