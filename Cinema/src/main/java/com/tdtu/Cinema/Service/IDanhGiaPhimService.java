package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.DanhGiaPhimEntity;
import com.tdtu.Cinema.Entity.DanhGiaPhimId;
import com.tdtu.Cinema.Entity.PhimEntity;

import java.util.List;

public interface IDanhGiaPhimService {
     DanhGiaPhimEntity save(DanhGiaPhimEntity danhGiaPhimEntity);
     List<DanhGiaPhimEntity> getDanhGiaPhimByPhim(Long idphim);
     List<DanhGiaPhimEntity> getall();

     void delete(DanhGiaPhimId id);
}
