package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.DTO.RapDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import com.tdtu.Cinema.Entity.SuatChieuEntity;
import com.tdtu.Cinema.Mapper.RapMapper;
import com.tdtu.Cinema.Service.IPhimService;
import com.tdtu.Cinema.Service.IRapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class RapUserAPI {
    @Autowired
    private IRapService rapService;

    @Autowired
    private IPhimService phimService;

    @GetMapping("/rap/{id}")
    public Set<RapEntity> getRapIdFilm(@PathVariable("id") Long id){
        Set<RapEntity> list = new HashSet<>();
        PhimEntity phim= phimService.findOneById(id);
        List<SuatChieuEntity> listsuatchieu = phim.getListSuatChieu();
        for(SuatChieuEntity sc : listsuatchieu){
            list.add(sc.getRap_suatchieu());
        }
        return  list;

    }

    @GetMapping("/rapupdate/{id}")
    public RapDTO getraptoupdate(@PathVariable("id") Long id){
        return  RapMapper.toDTO(rapService.getOneById(id));

    }
}
