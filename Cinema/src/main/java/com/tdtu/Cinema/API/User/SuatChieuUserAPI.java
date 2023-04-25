package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.SuatChieuEntity;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import com.tdtu.Cinema.Service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class SuatChieuUserAPI {

    @Autowired
    private IRapService rapService;

    @Autowired
    private IPhimService phimService;

    @Autowired
    private ISuatChieuService suatChieuService;

    @GetMapping("/suatchieu")
    public List<SuatChieuEntity> getAllACByRapPhim(@RequestParam("idphim") long idp, @RequestParam("idrap") long idr){
        List<SuatChieuEntity> suatChieuEntities = new ArrayList<>();
        PhimEntity phim= phimService.findOneById(idp);
        List<SuatChieuEntity> listinphim = phim.getListSuatChieu();
        for(SuatChieuEntity sc : listinphim){
            if(sc.getRap_suatchieu().getId() == idr){
                suatChieuEntities.add(sc);
            }

        }
        return  suatChieuEntities;

    }

    @GetMapping("/suatchieutinh")
    public List<SuatChieuEntity> getsuatchieutheotinh(@RequestParam("idphim") long idphim,@RequestParam("idtinh") long idtinh){
        List<SuatChieuEntity> suatChieuEntities = new ArrayList<>();
        suatChieuEntities = suatChieuService.getByIdTinh(idtinh,idphim);
        return  suatChieuEntities;
    }

    @GetMapping("/suatchieungay")
    public List<SuatChieuEntity> getsuatchieutheongay(@RequestParam("idphim") long idphim,@RequestParam("ngay") String ngay){
        List<SuatChieuEntity> suatChieuEntities = new ArrayList<>();
        suatChieuEntities = suatChieuService.getByNgaychieu(ngay,idphim);
        return  suatChieuEntities;
    }

    @GetMapping("/suatchieuRap")
    public List<SuatChieuEntity> getsuatchieutheorap(@RequestParam("idphim") long idphim,@RequestParam("idrap") Long idrap){
        List<SuatChieuEntity> suatChieuEntities = new ArrayList<>();
        suatChieuEntities = suatChieuService.getByIdRap(idrap,idphim);
        return  suatChieuEntities;
    }
}
