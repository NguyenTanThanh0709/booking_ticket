package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Entity.UserEnity;

import java.util.List;

public interface IThanhToanService {
    List<ThanhToanEntity> save(List<ThanhToanEntity> thanhToanEntity);
    ThanhToanEntity getOneByid(Long id);
    List<ThanhToanEntity> getall();
    List<ThanhToanEntity> getTTUser(UserEnity userEnity);

    List<ThanhToanEntity> chuyendoivethanhtoanANDSAVE(Long idSuatchieu, Long idUser, Long idFood, Long idVe, long[] idGhe, int tongtien , int soluongfood);

}
