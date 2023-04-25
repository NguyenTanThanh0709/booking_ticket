package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Mapper.PhimMapper;
import com.tdtu.Cinema.Repository.PhimepositoryPaging;
import com.tdtu.Cinema.Repository.phimRepository;
import com.tdtu.Cinema.Service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhimService implements IPhimService {

    @Autowired
    private phimRepository phimRepository;

    @Autowired
    private PhimepositoryPaging phimepositoryPaging;

    @Override
    public Page<PhimEntity> Page(int start, int end) {
        Pageable pageable = PageRequest.of(start, end, Sort.by("id").ascending());
        return phimepositoryPaging.findAll(pageable);
    }

    @Override
    public List<PhimEntity> findAll() {
        return phimRepository.findAll();
    }

    @Override
    public PhimEntity findOneById(Long id) {
        return phimRepository.findById(id).get();
    }

    @Override
    public List<PhimEntity> findByTheLoai(String theloai) {
        return phimRepository.findByTheloai(theloai);
    }

    @Override
    public List<PhimEntity> findByLoaiphim(String theloai) {
        return phimRepository.findByLoaiphim(theloai);
    }

    @Override
    public List<PhimEntity> findByTenphimContaining(String tenphim) {
        return phimRepository.findByTenphimContaining(tenphim);
    }

    @Override
    public List<PhimEntity> findByDotuoi(int tuoi) {
        return phimRepository.findByTuoiLessThan(tuoi);
    }

    @Override
    public PhimEntity save(PhimDTO phim) {
        PhimEntity phimEntity = new PhimEntity();

        if(phim.getId() != null){
            return update(phim);
        }else {
            phimEntity = PhimMapper.toEntity(phim);
        }
        return phimRepository.save(phimEntity);
    }

    @Override
    public PhimEntity update(PhimDTO phim) {
        PhimEntity phimEntity = new PhimEntity();

        phimEntity = PhimMapper.toEntity(phim);

        PhimEntity phimtemp = phimRepository.findById(phimEntity.getId()).get();

        phimEntity.setLikeRap(phimtemp.getLikeRap());
        phimEntity.setListDanhGia(phimtemp.getListDanhGia());
        phimEntity.setListSuatChieu(phimtemp.getListSuatChieu());
        phimEntity.setListThanhToan(phimtemp.getListThanhToan());
        phimEntity.setNhaXuatBan_phim(phimtemp.getNhaXuatBan_phim());

        return phimRepository.save(phimEntity);
    }

    @Override
    public List<PhimEntity> findByTrangthai(String trangthai) {
        return phimRepository.findByTrangthai(trangthai);
    }


}
