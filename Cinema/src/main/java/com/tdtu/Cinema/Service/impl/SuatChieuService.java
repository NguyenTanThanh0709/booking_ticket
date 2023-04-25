package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.SuatChieuEntity;
import com.tdtu.Cinema.Repository.SuatChieuRepository;
import com.tdtu.Cinema.Service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SuatChieuService implements ISuatChieuService {

    @Autowired
    private SuatChieuRepository suatChieuRepository;

    @Override
    public List<SuatChieuEntity> getAll() {
        return suatChieuRepository.findAll();
    }

    @Override
    public SuatChieuEntity save(SuatChieuEntity id) {
        return suatChieuRepository.save(id);
    }

    @Override
    public SuatChieuEntity getByid(Long id) {
        return suatChieuRepository.findById(id).get();
    }

    @Override
    public List<SuatChieuEntity> getByIdPhim(Long idphim) {
        List<SuatChieuEntity> suatChieuList = getAll()
                .stream()
                .filter(sc -> sc.getPhim_suatChieu().getId().equals(idphim))
                .collect(Collectors.toList());
        return suatChieuList;
    }

    @Override
    public List<SuatChieuEntity> getByIdRap(Long idrap, Long idphim) {
        List<SuatChieuEntity> main = getByIdPhim(idphim);
        List<SuatChieuEntity> suatChieuList = main
                .stream()
                .filter(sc -> sc.getRap_suatchieu().getId().equals(idrap))
                .collect(Collectors.toList());
        return suatChieuList;
    }

    @Override
    public List<SuatChieuEntity> getByIdTinh(Long idtinh,  Long idphim) {
        List<SuatChieuEntity> main = getByIdPhim(idphim);
        List<SuatChieuEntity> suatChieuList = main
                .stream()
                .filter(sc -> sc.getRap_suatchieu().getTinhThanh_rap().getId().equals(idtinh))
                .collect(Collectors.toList());
        return suatChieuList;
    }

    @Override
    public List<SuatChieuEntity> getByNgaychieu(String ngaychieu,  Long idphim) {
        List<SuatChieuEntity> main = getByIdPhim(idphim);
        List<SuatChieuEntity> suatChieuList = main
                .stream()
                .filter(sc -> sc.getNgayChieu().equals(ngaychieu))
                .collect(Collectors.toList());
        return suatChieuList;
    }

    @Override
    public List<SuatChieuEntity> getByTinhNgayRap(Long idtinh, String ngaychieu, Long idrap,  Long idphim) {
        List<SuatChieuEntity> list = new ArrayList<>();
        List<SuatChieuEntity> listMain = getByIdPhim(idphim);
        for(SuatChieuEntity sc : listMain){
            if(sc.getNgayChieu().equalsIgnoreCase(ngaychieu) && sc.getRap_suatchieu().getId() == idrap && sc.getRap_suatchieu().getTinhThanh_rap().getId() == idtinh){
                list.add(sc);
            }
        }
        return list;
    }
}
