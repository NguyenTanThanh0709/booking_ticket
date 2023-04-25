package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.TinhThanhEntity;

import java.util.List;

public interface ITinhThanhService {
    List<TinhThanhEntity> getall();
    TinhThanhEntity getOneById(Long id);
}
