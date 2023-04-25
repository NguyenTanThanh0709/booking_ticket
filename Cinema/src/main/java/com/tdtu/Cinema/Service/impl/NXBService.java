package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Mapper.NXBMapper;
import com.tdtu.Cinema.Repository.NhaXuatBanRepository;
import com.tdtu.Cinema.Service.INXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NXBService implements INXBService {

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;
    @Override
    public List<NhaXuatBanEntity> getall() {
        return nhaXuatBanRepository.findAll();
    }

    @Override
    public NhaXuatBanEntity getone(Long id) {
        return nhaXuatBanRepository.findById(id).get();
    }

    @Override
    public NhaXuatBanEntity save(NxbDTO nxb) {
        if(nxb.getId() != null){
            NhaXuatBanEntity nxb__ = NXBMapper.toEntity(nxb);
            NhaXuatBanEntity nxbtemp = getone(nxb.getId());
            nxb__.setListPhims(nxbtemp.getListPhims());
            return nhaXuatBanRepository.save(nxb__);
        }else{
            NhaXuatBanEntity nxb__ = NXBMapper.toEntity(nxb);
            return nhaXuatBanRepository.save(nxb__);
        }

    }

}
