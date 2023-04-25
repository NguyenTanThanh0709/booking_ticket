package com.tdtu.Cinema.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhimController {
    @GetMapping({"/qlphim"})
    public String qlphim(Model model) {
        return "/Admin/qlphim";
    }
}
