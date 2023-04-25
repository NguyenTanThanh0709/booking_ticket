package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Repository.RapRepositoty;
import com.tdtu.Cinema.Service.IRapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RapService implements IRapService {

    @Autowired
    private RapRepositoty rapRepositoty;

    @Override
    public RapEntity save(RapEntity rap) {
        return rapRepositoty.save(rap);
    }

    @Override
    public List<RapEntity> getall() {
        return rapRepositoty.findAll();
    }

    @Override
    public RapEntity getOneById(Long id) {
        return rapRepositoty.findById(id).get();
    }
}
