package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.DTO.RapDTO;
import com.tdtu.Cinema.Entity.*;
import com.tdtu.Cinema.Mapper.RapMapper;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.ISuatChieuService;
import com.tdtu.Cinema.Service.ITinhThanhService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class RapADMIN {

    @Autowired
    private IRapService rapService;

    @Autowired
    private ITinhThanhService tinhThanhService;

    @Autowired
    private ISuatChieuService suatChieuService;


    @PostMapping(value = "/rap/{id}", consumes = "application/json;charset=UTF-8") //,
    public RapEntity update(@RequestBody RapDTO model, @PathVariable("id") long id){
        TinhThanhEntity tinhThanhEntity = tinhThanhService.getOneById(id);
        RapEntity r = RapMapper.toEntity(model);
        r.setTinhThanh_rap(tinhThanhEntity);
        return  rapService.save(r);
    }

    @PostMapping(value = "/updater")
    public void update_(@RequestParam("id") Long id,
                        @RequestParam("tenRap") String tenRap,
                        @RequestParam("imgRap") String imgRap,
                        @RequestParam("diaChi") String diaChi,
                        @RequestParam("trangthai") String trangthai, HttpServletResponse response) throws IOException {
        RapEntity rapEntity = rapService.getOneById(id);
        rapEntity.setImgRap(imgRap);
        rapEntity.setTenRap(tenRap);
        rapEntity.setDiaChi(diaChi);
        rapEntity.setTrangthai(trangthai);
        rapService.save(rapEntity);
        response.sendRedirect("/qlrap");
    }

    @GetMapping(value = "/phongrap")
    public Set<PhongChieuEntity> getphongchieu(@RequestParam("id") Long id){

        RapEntity rapEntity = rapService.getOneById(id);
        List<PhongChieuEntity> phongChieuEntities = rapEntity.getListRaps();
        List<SuatChieuEntity> suatChieuEntities =suatChieuService.getAll();
        Set<PhongChieuEntity> phongRaps = new HashSet<>();

        for (PhongChieuEntity pc: phongChieuEntities
             ) {
            for (SuatChieuEntity sc :suatChieuEntities
                 ) {
                if(pc.getId() == sc.getPhongChieu_suatchieu().getId() ){
                    if(sc.getInfo().equalsIgnoreCase("sắp chiếu")){
                        phongRaps.add(pc);
                    }
                }else{
                    phongRaps.add(pc);
                }
            }
        }
        return phongRaps;
    }
}
