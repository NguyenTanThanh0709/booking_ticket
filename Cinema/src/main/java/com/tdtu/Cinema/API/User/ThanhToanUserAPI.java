package com.tdtu.Cinema.API.User;


import com.tdtu.Cinema.DTO.ThanhToanDTO;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Service.IThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class ThanhToanUserAPI {

    @Autowired
    private IThanhToanService thanhToanService;


    @PostMapping("/thanhtoan")
    public List<ThanhToanEntity> save(@RequestBody ThanhToanDTO model){
        List<ThanhToanEntity> list =
                thanhToanService.chuyendoivethanhtoanANDSAVE(model.getIdSuatchieu(), model.getIdUser(), model.getIdFood(), model.getIdVe()
                , model.getIdGhe(), model.getTongtien(), model.getSoluongfood());

        return  thanhToanService.save(list);
    }

}
