package com.tdtu.Cinema.API.User;

import com.tdtu.Cinema.Entity.KhuyenMaiEntity;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Service.IKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class KhuyenMaiAPI {

    @Autowired
    private IKhuyenMaiService khuyenMaiService;

    @GetMapping("/gettallkhuyenmai")
    public List<KhuyenMaiEntity> getall(){
        return  khuyenMaiService.getall();
    }

    @GetMapping("/getonekhuyenmai/{id}")
    public KhuyenMaiEntity getone( @PathVariable("id") long id){
        return  khuyenMaiService.getone(id);
    }


}
