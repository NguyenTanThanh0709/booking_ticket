package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping({"/qlsuatchieu"})
    public String qlsuatchieu(Model model) {
        List<PhimEntity> listphim = phimService.findAll();
        List<RapEntity> listrap = rapService.getall();
        model.addAttribute("phims", listphim);
        model.addAttribute("raps", listrap  );
        return "/Admin/qlsuatchieu";
    }
}
