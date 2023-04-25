package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.VeEntity;
import com.tdtu.Cinema.Service.IVeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class VeUserAPI {
    @Autowired
    private IVeService veService;

    @GetMapping("/getoneve/{id}")
    public VeEntity getone(@PathVariable("id") long id){
        return  veService.getOneById(id);
    }
}
