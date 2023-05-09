package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.Entity.DanhGiaPhimEntity;
import com.tdtu.Cinema.Entity.DanhGiaPhimId;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Service.IDanhGiaPhimService;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")

public class DanhGiaPhimADMIN {

    @Autowired
    private IDanhGiaPhimService danhGiaPhimService;

    @Autowired
    private IPhimService phimService;

    @GetMapping("/danhgiaphim/{id}")
    public List<DanhGiaPhimEntity> getone(@PathVariable("id") long id){
        List<DanhGiaPhimEntity> list = danhGiaPhimService.getDanhGiaPhimByPhim(id);
        return  list;
    }

    @DeleteMapping("/xoadanhgia")
    public DanhGiaPhimId delete(@RequestParam("idu") Long idu,@RequestParam("idp") Long idp){
        DanhGiaPhimId danhGiaPhimId = new DanhGiaPhimId(idu,idp);
        danhGiaPhimService.delete(danhGiaPhimId);
        return danhGiaPhimId;
    }
}
