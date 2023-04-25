package com.tdtu.Cinema.API.Admin;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class PhimAPI {

    @Autowired
    private IPhimService phimService;
    @PostMapping("/film")
    public PhimEntity save(@RequestBody PhimDTO model){
        return phimService.save(model);
    }

    @PutMapping(value = "/film/{id}")
    public PhimEntity updateNew(@RequestBody PhimDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return  phimService.update(model);
    }

}
