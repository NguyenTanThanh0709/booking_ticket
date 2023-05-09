package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
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
public class KhuyenMaiController {

    @Autowired
    private IKhuyenMaiService khuyenMaiService;

    @Autowired
    private IUserService userService;

    @GetMapping({"/qlkhuyenmai"})

    public String qlkhuyenmai(Model model,  HttpSession session) {
        List<KhuyenMaiEntity> khuyenMaiEntities = new ArrayList<>();
        khuyenMaiEntities = khuyenMaiService.getall();
        model.addAttribute("listkMAI", khuyenMaiEntities);
        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);
        return "Admin/qlkhuyenmai";
    }
}
