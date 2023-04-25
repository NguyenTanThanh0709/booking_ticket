package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.VeEntity;
import com.tdtu.Cinema.Service.IVeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VeController {
    @Autowired
    private IVeService veService;
    @GetMapping({"/qlve"})
    public String qlve(Model model) {
        List<VeEntity> list = veService.getall();
        model.addAttribute("listve", list);

        return "/Admin/qlve";
    }
}
