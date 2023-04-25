package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.SuatChieuEntity;

import java.util.List;

public interface ISuatChieuService {
    List<SuatChieuEntity> getAll();
    SuatChieuEntity save(SuatChieuEntity id);
    SuatChieuEntity getByid(Long id);
    List<SuatChieuEntity> getByIdPhim(Long idphim);
    List<SuatChieuEntity> getByIdRap(Long idrap,  Long idphim);
    List<SuatChieuEntity> getByIdTinh(Long idtinh,  Long idphim);

    List<SuatChieuEntity> getByNgaychieu(String ngaychieu,  Long idphim);

    List<SuatChieuEntity> getByTinhNgayRap(Long idtinh,String ngaychieu, Long idrap,  Long idphim);



}
