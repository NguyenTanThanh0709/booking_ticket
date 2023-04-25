package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;

import java.util.List;

public interface INXBService {

    List<NhaXuatBanEntity> getall();
    NhaXuatBanEntity getone(Long id);
    NhaXuatBanEntity save(NxbDTO nxb);

}
