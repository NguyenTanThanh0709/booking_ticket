package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class KhuyenMaiAPIADMIN {
    @Autowired
    private IKhuyenMaiService khuyenMaiService;
    @PutMapping(value = "/khuyenmai/{id}", consumes = "application/json;charset=UTF-8")
    public KhuyenMaiEntity update(@RequestBody KhuyenMaiEntity model, @PathVariable("id") long id){
        model.setId(id);
        return  khuyenMaiService.save(model);
    }
    @PostMapping("/khuyenmaiu")
    public void save(@RequestParam("id") Long id,
                     @RequestParam("tenRap") String tenRap,
                     @RequestParam("imgRap") String imgRap,
                     @RequestParam("diaChi") int diaChi,
                     @RequestParam("trangthai") String trangthai, HttpServletResponse response) throws IOException {
        KhuyenMaiEntity khuyenMaiEntity = new KhuyenMaiEntity();
        if(id != -1){
            khuyenMaiEntity.setId(id);
        }

        khuyenMaiEntity.setImg(imgRap);
        khuyenMaiEntity.setTienkhuyenmai(diaChi);
        khuyenMaiEntity.setTrangthai(trangthai);
        khuyenMaiEntity.setTenkhuyenmai(tenRap);
        khuyenMaiService.save(khuyenMaiEntity);
        response.sendRedirect("/qlkhuyenmai");
    }

}
