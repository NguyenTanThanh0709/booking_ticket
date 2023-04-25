package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Repository.FoodRepository;
import com.tdtu.Cinema.Service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodService implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Override
    public List<FoodEntity> getall() {
        return foodRepository.findAll();
    }

    @Override
    public FoodEntity getone(Long id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public FoodEntity save(FoodEntity foodEntity) {
        return foodRepository.save(foodEntity);
    }
}
