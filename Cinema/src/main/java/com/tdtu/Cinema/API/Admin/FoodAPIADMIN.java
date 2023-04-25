package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.Entity.FoodEntity;
import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Service.IFoodService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class FoodAPIADMIN {

    @Autowired
    private IFoodService foodService;
    @PostMapping("/foodnew")
    public void save(@RequestParam("id") Long id,
                     @RequestParam("tenRap") String tenRap,
                     @RequestParam("imgRap") String imgRap,
                     @RequestParam("gia") int gia,
                     @RequestParam("noidung") String noidung,
                     @RequestParam("trangthai") String trangthai, HttpServletResponse response) throws IOException {
        FoodEntity khuyenMaiEntity = new FoodEntity();
        if(id != -1){
            khuyenMaiEntity.setId(id);
        }
        khuyenMaiEntity.setNamefood(tenRap);
        khuyenMaiEntity.setGia(gia);
        khuyenMaiEntity.setNoidung(noidung);
        khuyenMaiEntity.setTrangthai(trangthai);
        khuyenMaiEntity.setImage(imgRap);
        foodService.save(khuyenMaiEntity);
        response.sendRedirect("/qlfood");
    }
}
