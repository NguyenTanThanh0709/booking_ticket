package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.RapEntity;

import java.util.List;

public interface IRapService {
    RapEntity save(RapEntity rap);
    List<RapEntity> getall();
    RapEntity getOneById(Long id);
}
