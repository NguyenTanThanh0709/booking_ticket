package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.GheEntity;
import com.tdtu.Cinema.Entity.SuatChieuEntity;
import com.tdtu.Cinema.Entity.ThanhToanEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Repository.GheRopository;
import com.tdtu.Cinema.Repository.ThanhToanRepository;
import com.tdtu.Cinema.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ThanhToanService implements IThanhToanService {

    @Autowired
    private ThanhToanRepository thanhToanRepository;

    @Autowired
    private GheRopository gheRopository;


    @Autowired
    private IFoodService foodService;

    @Autowired
    private IVeService veService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISuatChieuService suatChieuService;

    @Autowired
    private  IGheService gheService;
    @Override
    public List<ThanhToanEntity> save(List<ThanhToanEntity> lthanhToanEntity) {
        for (ThanhToanEntity tt :lthanhToanEntity) {
            GheEntity gheEntity = tt.getGhe_thanhtoan();
            gheEntity.setTrangThai("có người");
            tt.setGhe_thanhtoan(gheEntity);
            gheService.save(gheEntity);
            thanhToanRepository.save(tt);
        }
        return lthanhToanEntity;
    }

    @Override
    public ThanhToanEntity getOneByid(Long id) {
        return thanhToanRepository.findById(id).get();
    }

    @Override
    public List<ThanhToanEntity> getall() {
        return thanhToanRepository.findAll();
    }

    @Override
    public List<ThanhToanEntity> getTTUser(UserEnity userEnity) {
        return thanhToanRepository.findByUserThanhtoan(userEnity);
    }

    @Override
    public List<ThanhToanEntity> chuyendoivethanhtoanANDSAVE(Long idSuatchieu, Long idUser, Long idFood, Long idVe, long[] idGhe, int tongtien, int soluongfood) {
        List<ThanhToanEntity> list = new ArrayList<>();

        for (long idghe : idGhe) {
            GheEntity ghe = gheRopository.findById(idghe).get();

            ThanhToanEntity thanhToanEntity = new ThanhToanEntity();

            thanhToanEntity.setGhe_thanhtoan(ghe);
            thanhToanEntity.setSoluongve(1);
            thanhToanEntity.setSoluongfood(soluongfood);
            thanhToanEntity.setTongtien(tongtien);
            thanhToanEntity.setUser_thanhtoan(userService.getonrbyid(idUser));

            if(idFood != 0){
                thanhToanEntity.setFood_thanhtoan(foodService.getone(idFood));
            }


            thanhToanEntity.setVe_thanhtoan(veService.getOneById(idVe));

            SuatChieuEntity suatChieuEntity = suatChieuService.getByid(idSuatchieu);
            thanhToanEntity.setPhim_thanhtoan(suatChieuEntity.getPhim_suatChieu());
            thanhToanEntity.setRap_thanhtoan(suatChieuEntity.getRap_suatchieu());
            thanhToanEntity.setSuatChieu_thanhtoan(suatChieuEntity);
            thanhToanEntity.setPhongChieu_thanhtoan(suatChieuEntity.getPhongChieu_suatchieu());

            list.add(thanhToanEntity);
        }
        return list;
    }
}
