package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.DTO.DanhGiaPhimDTO;
import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.DTO.ThanhToanDTO;
import com.tdtu.Cinema.Entity.*;
import com.tdtu.Cinema.Service.IDanhGiaPhimService;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class DanhGiaPhimUserAPI {

    @Autowired
    private IDanhGiaPhimService danhGiaPhimService;

    @Autowired
    private IPhimService phimService;

    @Autowired
    private IUserService userService;

    @DeleteMapping("/danhgia")
    public String delete(@RequestParam("iduser") long iduser, @RequestParam("idphim") long idphim){
        DanhGiaPhimId id = new DanhGiaPhimId(iduser, idphim);
        danhGiaPhimService.delete(id);
        return "ok";
    }

    @PostMapping("/danhgia")
    public DanhGiaPhimEntity save(@RequestBody DanhGiaPhimDTO model){

        DanhGiaPhimEntity danhGiaPhimEntity = new DanhGiaPhimEntity();

        DanhGiaPhimId id = new DanhGiaPhimId();
        id.setPhim_danhgia(model.getPhim_danhgia());
        id.setUser_danhgia(model.getUser_danhgia());

        danhGiaPhimEntity.setId(id);
        danhGiaPhimEntity.setTieude(model.getTieude());
        danhGiaPhimEntity.setDanhGia(model.getDanhgia());

        PhimEntity phim = phimService.findOneById(model.getPhim_danhgia());
        UserEnity user = userService.getonrbyid(model.getUser_danhgia());

        danhGiaPhimEntity.setPhim_danhgia_main(phim);
        danhGiaPhimEntity.setUser_danhgia_main(user);


        return danhGiaPhimService.save(danhGiaPhimEntity);
    }
}
