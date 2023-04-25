package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class PhimAPIUser {
    @Autowired
    private IPhimService phimService;

    @GetMapping("/gettallphim")
    public List<PhimEntity> getall(){
        return  phimService.findAll();
    }

    @GetMapping("/getone/{id}")
    public PhimEntity getone( @PathVariable("id") long id){
        return  phimService.findOneById(id);
    }

    @GetMapping("/gettheloai")
    public List<PhimEntity> gettheloai( @RequestBody String theloai){
        return  phimService.findByTheLoai(theloai);
    }

    @GetMapping("/getdotuoi/{tuoi}")
    public List<PhimEntity> getdotuoi( @PathVariable("tuoi") int tuoi){
        return  phimService.findByDotuoi(tuoi);
    }

    @GetMapping("/loaiphim")
    public List<PhimEntity> getloaiphim( @RequestParam("loai") String loaiphim){
        return  phimService.findByLoaiphim(loaiphim);
    }

    @GetMapping("/search")
    public List<PhimEntity> search( @RequestParam("ten") String ten){
        return  phimService.findByTenphimContaining(ten);
    }




}
