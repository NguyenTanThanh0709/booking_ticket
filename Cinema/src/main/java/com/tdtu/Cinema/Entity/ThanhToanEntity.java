package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "thanhtoan")
@Data
public class ThanhToanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int soluongve;
    private int soluongfood;
    private int tongtien;

    @ManyToOne
    @JoinColumn(name = "idphim")
    @JsonBackReference
    private PhimEntity phim_thanhtoan;

    @ManyToOne
    @JoinColumn(name = "idrap")
    @JsonBackReference
    private RapEntity rap_thanhtoan;

    private String ngay;


    @ManyToOne
    @JoinColumn(name = "idsuatchieu")
    @JsonBackReference
    private SuatChieuEntity suatChieu_thanhtoan;

    @ManyToOne
    @JoinColumn(name = "idphongchieu")
    @JsonBackReference
    private PhongChieuEntity phongChieu_thanhtoan;

    @ManyToOne
    @JoinColumn(name = "idve")
    @JsonBackReference
    private VeEntity ve_thanhtoan;


    @ManyToOne
    @JoinColumn(name = "idfood")
    @JsonBackReference
    private FoodEntity food_thanhtoan;


    @ManyToOne
    @JoinColumn(name = "idghe")
    @JsonBackReference
    private GheEntity ghe_thanhtoan;

    @ManyToOne
    @JoinColumn(name = "iduser")
    @JsonBackReference
    private UserEnity user_thanhtoan;

}
