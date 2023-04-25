package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.GheEntity;
import com.tdtu.Cinema.Repository.GheRopository;
import com.tdtu.Cinema.Service.IGheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GheSerivve implements IGheService {

    @Autowired
    private GheRopository gheRopository;


    @Override
    public GheEntity save(GheEntity ghe) {
        return gheRopository.save(ghe);
    }
}
