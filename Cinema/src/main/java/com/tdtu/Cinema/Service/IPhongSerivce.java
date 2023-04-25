package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.PhongChieuEntity;

import java.util.List;

public interface IPhongSerivce {
    List<PhongChieuEntity> getAll();
    PhongChieuEntity getone(Long id);

}
