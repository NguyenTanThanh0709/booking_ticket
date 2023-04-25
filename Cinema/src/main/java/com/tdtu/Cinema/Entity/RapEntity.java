package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rap")
@Data
public class RapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenrap", nullable = false, length = 50)
    private String tenRap;

    private String imgRap;
    private String trangthai;
    @Column(name = "diachi", nullable = false, length = 50)
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "idtinhthanh")
    @JsonBackReference
    private TinhThanhEntity tinhThanh_rap;



    @ManyToMany(mappedBy = "likeRap")
    @JsonManagedReference
    private Set<PhimEntity> likesPhim;


    @OneToMany(mappedBy = "rap_phongchieu")
    @JsonManagedReference
    private List<PhongChieuEntity> listRaps = new ArrayList<>();

    @OneToMany(mappedBy = "rap_suatchieu")
    @JsonManagedReference
    private List<SuatChieuEntity> listSuatChieu = new ArrayList<>();

    @OneToMany(mappedBy = "rap_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();



    public int gettongtien(){
        int tt = 0;
        for ( ThanhToanEntity t: this.getListThanhToan()) {
                tt += t.getTongtien();
        }
        return tt;
    }
}