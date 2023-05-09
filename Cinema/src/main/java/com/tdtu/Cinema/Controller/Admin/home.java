package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Mapper.PhimMapper;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminHome")
public class home {

    @Autowired
    private IRapService rapService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPhimService phimService;
    @GetMapping({"/", ""})
    @PreAuthorize(value = "hasRole('ADMIN')")
    public String home(Model model,  HttpSession session) {
        List<PhimEntity> listphim = phimService.findAll();

        int tongdoanhthuphim  = 0;
        for ( PhimEntity r: listphim) {
            for (ThanhToanEntity tt : r.getListThanhToan()) {
                tongdoanhthuphim += tt.getTongtien();
            }
        }

        String sdt = (String)session.getAttribute("sdt");
        UserEnity userEnity = userService.findBySdt(sdt).get();
        model.addAttribute("user",userEnity);

        model.addAttribute("tongdoanhthuphim", tongdoanhthuphim);
        model.addAttribute("listphim", listphim);


        List<RapEntity> listrap =rapService.getall();
        int tongdoanhthurap  = 0;
        for ( RapEntity r: listrap) {
            for (ThanhToanEntity tt : r.getListThanhToan()) {
                tongdoanhthurap += tt.getTongtien();
            }
        }
        model.addAttribute("tongdoanhthurap", tongdoanhthurap);
        model.addAttribute("listrap", listrap);
        return "/Admin/home";
    }

















}
