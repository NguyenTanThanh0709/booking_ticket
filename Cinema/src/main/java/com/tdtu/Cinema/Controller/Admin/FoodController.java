package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IFoodService;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @Autowired
    private IUserService userService;
    @GetMapping({"/qlfood"})



    public String qlfood(Model model,  HttpSession session) {
        List<FoodEntity> foods = new ArrayList<>();
        foods = foodService.getall();
        model.addAttribute("foods",foods );
        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);
        return "Admin/qlfood";
    }
}
