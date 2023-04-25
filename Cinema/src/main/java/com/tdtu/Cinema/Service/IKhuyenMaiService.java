package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;

import java.util.List;

public interface IKhuyenMaiService {
    List<KhuyenMaiEntity> getall();
    KhuyenMaiEntity getone(Long id);
    KhuyenMaiEntity save(KhuyenMaiEntity khuyenMaiEntity);
}
