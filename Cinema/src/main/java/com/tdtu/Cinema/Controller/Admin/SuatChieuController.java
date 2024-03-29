package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SuatChieuController {

    @Autowired
    private IPhimService phimService;

    @Autowired
    private IRapService rapService;
    @Autowired
    private IUserService userService;
    @GetMapping({"/qlsuatchieu"})

    public String qlsuatchieu(Model model,  HttpSession session) {
        List<PhimEntity> listphim = phimService.findAll();
        List<RapEntity> listrap = rapService.getall();
        model.addAttribute("phims", listphim);
        model.addAttribute("raps", listrap  );
        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);
        return "Admin/qlsuatchieu";
    }
}
