package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.ITinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RapController {

    @Autowired
    private IRapService rapService;

    @Autowired
    private ITinhThanhService tinhThanhService;



    @GetMapping({"/qlrap"})
    public String qlrap(Model model) {

        List<RapEntity> listrap = rapService.getall();
        model.addAttribute("tinh",tinhThanhService.getall());

        model.addAttribute("listrap",listrap);
        return "/Admin/qlrap";
    }
}
