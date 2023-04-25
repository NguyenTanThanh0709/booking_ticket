package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.VeEntity;

import java.util.List;

public interface IVeService {
    List<VeEntity> getall();
    VeEntity getOneById(Long id);

    VeEntity save(VeEntity veEntity);
}
