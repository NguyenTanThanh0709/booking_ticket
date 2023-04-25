package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class FoodAPI {

    @Autowired
    private IFoodService foodService;
    @GetMapping("/getonefood/{id}")
    public FoodEntity getone(@PathVariable("id") long id){
        return  foodService.getone(id);
    }
}
