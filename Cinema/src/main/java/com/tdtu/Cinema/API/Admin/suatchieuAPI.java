package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.PhongChieuEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.SuatChieuEntity;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IPhongSerivce;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.ISuatChieuService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class suatchieuAPI {

    @Autowired
    private IPhimService phimService;

    @Autowired
    private IPhongSerivce phongSerivce;

    @Autowired
    private IRapService rapService;

    @Autowired
    private ISuatChieuService suatChieuService;

    @GetMapping("/xemsuatchieu")
    public List<SuatChieuEntity> getsc(@RequestParam("idphim") Long idphim,@RequestParam("idrap") Long idrap){
        if(idrap == -1 && idphim == -1){
            return suatChieuService.getAll();
        }
        return suatChieuService.getByIdRap(idrap,idphim);
    }

    @GetMapping("/getonesc")
    public SuatChieuEntity getsc(@RequestParam("id") Long id){
        return suatChieuService.getByid(id);
    }

    @PostMapping("/themsuatchieu")
    public void insert(
            @RequestParam("id") Long id,
            @RequestParam("ngaychieu") String ngaychieu,
            @RequestParam("giochieu") String giochieu,
            @RequestParam("info") String info,
            @RequestParam("rap") Long rap,
            @RequestParam("phong") Long phong,
            @RequestParam("phim") Long phim
            , HttpServletResponse response) throws IOException {
        if(id != -1){
            return  ;
        }
        SuatChieuEntity suatChieuEntity = new SuatChieuEntity();
        suatChieuEntity.setInfo(info);
        suatChieuEntity.setThoiGian(giochieu);
        suatChieuEntity.setNgayChieu(ngaychieu);

        PhimEntity phimentity = phimService.findOneById(phim);
        RapEntity rapEntity = rapService.getOneById(rap);
        PhongChieuEntity phongChieuEntity = phongSerivce.getone(phong);

        suatChieuEntity.setPhongChieu_suatchieu(phongChieuEntity);
        suatChieuEntity.setRap_suatchieu(rapEntity);
        suatChieuEntity.setPhim_suatChieu(phimentity);

          suatChieuService.save(suatChieuEntity);
        response.sendRedirect("/qlsuatchieu");
    }

    @PostMapping("/updatesc")
    public void update(@RequestParam("id") Long id,
                                  @RequestParam("ngaychieu") String ngaychieu,
                                  @RequestParam("giochieu") String giochieu,
                                  @RequestParam("info") String info, HttpServletResponse response) throws IOException {

        SuatChieuEntity suatChieuEntity = suatChieuService.getByid(id);
        suatChieuEntity.setNgayChieu(ngaychieu);
        suatChieuEntity.setThoiGian(giochieu);
        suatChieuEntity.setInfo(info);

          suatChieuService.save(suatChieuEntity);
        response.sendRedirect("/qlsuatchieu");
    }
}
