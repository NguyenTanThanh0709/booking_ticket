package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suatchieu")
@Data
public class SuatChieuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ngaychieu")
    private String ngayChieu;

    @Column(name = "info")
    private String info;

    @Column(name = "thoigian", nullable = false)
    private String thoiGian;


    @ManyToOne
    @JoinColumn(name = "idrap")
    @JsonBackReference
    private RapEntity rap_suatchieu;

    @ManyToOne
    @JoinColumn(name = "idphongchieu")
    @JsonBackReference
    private PhongChieuEntity phongChieu_suatchieu;

    @ManyToOne
    @JoinColumn(name = "idphim")
    @JsonBackReference
    private PhimEntity phim_suatChieu;

    @OneToMany(mappedBy = "suatChieu_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();

}
