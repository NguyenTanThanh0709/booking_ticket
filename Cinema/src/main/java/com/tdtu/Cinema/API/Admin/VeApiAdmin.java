package com.tdtu.Cinema.API.Admin;


import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.VeEntity;
import com.tdtu.Cinema.Service.IVeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class VeApiAdmin {

    @Autowired
    private IVeService veService;


    @PostMapping("/venew")
    public void save(@RequestParam("id") Long id,
                     @RequestParam("tenRap") String tenRap,
                     @RequestParam("gia") int gia,
                     @RequestParam("noidung") String noidung,
                     @RequestParam("trangthai") String trangthai, HttpServletResponse response) throws IOException {
        VeEntity khuyenMaiEntity = new VeEntity();

        if(id != -1){
            khuyenMaiEntity = veService.getOneById(id);
        }
        khuyenMaiEntity.setTenve(tenRap);
        khuyenMaiEntity.setGiave(gia);
        khuyenMaiEntity.setNoidung(noidung);
        khuyenMaiEntity.setTrangthai(trangthai);

        veService.save(khuyenMaiEntity);
        response.sendRedirect("/qlve");
    }
}
