package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "phongchieu")
@Data
public class PhongChieuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenphong", nullable = false, length = 50)
    private String tenPhong;

    @ManyToOne
    @JoinColumn(name = "idrap")
    @JsonBackReference
    private RapEntity rap_phongchieu;

    @Column(name = "trangthai", columnDefinition = "VARCHAR(50) CHECK (trangthai IN ('1', '0'))")
    private String trangThai;

    @OneToMany(mappedBy = "phongChieu_hangghe")
    @JsonManagedReference
    private List<HangGheEntity> listhangghe = new ArrayList<>();

    @OneToMany(mappedBy = "phongChieu_suatchieu")
    @JsonManagedReference
    private List<SuatChieuEntity> listSuatChieu = new ArrayList<>();

    @OneToMany(mappedBy = "phongChieu_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();
}
