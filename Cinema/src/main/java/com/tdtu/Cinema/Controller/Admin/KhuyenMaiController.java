package com.tdtu.Cinema.Controller.Admin;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KhuyenMaiController {

    @Autowired
    private IKhuyenMaiService khuyenMaiService;

    @GetMapping({"/qlkhuyenmai"})
    public String qlkhuyenmai(Model model) {
        List<KhuyenMaiEntity> khuyenMaiEntities = new ArrayList<>();
        khuyenMaiEntities = khuyenMaiService.getall();
        model.addAttribute("listkMAI", khuyenMaiEntities);
        return "/Admin/qlkhuyenmai";
    }
}
