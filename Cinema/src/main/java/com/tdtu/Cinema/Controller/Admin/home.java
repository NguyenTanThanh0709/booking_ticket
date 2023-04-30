package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Mapper.PhimMapper;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private IPhimService phimService;
    @GetMapping({"/", ""})
    public String home(Model model) {
        List<PhimEntity> listphim = phimService.findAll();

        int tongdoanhthuphim  = 0;
        for ( PhimEntity r: listphim) {
            for (ThanhToanEntity tt : r.getListThanhToan()) {
                tongdoanhthuphim += tt.getTongtien();
            }
        }


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
