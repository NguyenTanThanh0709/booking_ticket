package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Service.INXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class NXB {
    @Autowired
    private INXBService inxbService;

    @GetMapping("/nxb")
    public List<NhaXuatBanEntity> getall(){
        return  inxbService.getall();
    }
    @GetMapping("/nxb/{id}")
    public NhaXuatBanEntity getone(@PathVariable("id") long id){
        return  inxbService.getone(id);
    }
    @PutMapping(value = "/nxb/{id}", consumes = "application/json;charset=UTF-8")
    public NhaXuatBanEntity update(@RequestBody NxbDTO model,@PathVariable("id") long id){
        model.setId(id);
        return  inxbService.save(model);
    }
    @PostMapping("/nxb")
    public NhaXuatBanEntity save(@RequestBody NxbDTO model){
        return  inxbService.save(model);
    }

}
