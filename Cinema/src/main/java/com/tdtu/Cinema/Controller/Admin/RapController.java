package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.ITinhThanhService;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private IUserService userService;


    @GetMapping({"/qlrap"})

    public String qlrap(Model model,  HttpSession session) {



        List<RapEntity> listrap = rapService.getall();
        model.addAttribute("tinh",tinhThanhService.getall());

        model.addAttribute("listrap",listrap);
        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);
        return "Admin/qlrap";
    }
}
