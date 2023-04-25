package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Repository.FoodRepository;

import java.util.List;

public interface IFoodService {
    List<FoodEntity> getall();
    FoodEntity getone(Long id);

    FoodEntity save(FoodEntity foodEntity);

    //NhaXuatBanEntity save(NxbDTO nxb);
}
