package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Entity.VeEntity;
import com.tdtu.Cinema.Service.IUserService;
import com.tdtu.Cinema.Service.IVeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VeController {
    @Autowired
    private IVeService veService;
    @Autowired
    private IUserService userService;
    @GetMapping({"/qlve"})

    public String qlve(Model model,  HttpSession session) {
        List<VeEntity> list = veService.getall();
        model.addAttribute("listve", list);
        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);
        return "Admin/qlve";
    }
}
