package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private IFoodService foodService;
    @GetMapping({"/qlfood"})
    public String qlfood(Model model) {
        List<FoodEntity> foods = new ArrayList<>();
        foods = foodService.getall();
        model.addAttribute("foods",foods );
        return "/Admin/qlfood";
    }
}
