package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Service.IDanhGiaPhimService;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DanhGiaController {


    @Autowired
    private IPhimService phimService;

    @GetMapping({"/qldanhgiaphim"})
    public String qldanhgiaphim(Model model) {
        List<PhimEntity> list =  phimService.findAll();
        model.addAttribute("listphim", list);
        return "/Admin/qldanhgiaphim";
    }
}
