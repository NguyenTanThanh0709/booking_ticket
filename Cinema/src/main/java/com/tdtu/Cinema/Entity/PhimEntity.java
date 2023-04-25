package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "phim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhimEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenphim")
    private String tenphim;

    @Column(name = "tuoi")
    private int tuoi;

    @Column(name = "theloai")
    private String theloai;

    @Column(name = "loaiphim")
    private String loaiphim; // 2d 3d

    @Column(name = "quocgia")
    private String quocgia;

    @Column(name = "dienvien")
    private String dienvien;

    @Column(name = "daodien")
    private String daodien;

    @Column(name = "ngaychieu")
    private String ngaychieu;

    @Column(name = "rating")
    private int rating;

    @Column(name = "thoiluong", columnDefinition = "int default 0")
    private int thoiluong;

    @Column(name = "noidung", columnDefinition = "TEXT")
    private String noidung;

    @Column(name = "trangthai")
    private String trangthai;

    private String ngaydong;

    @Column(name = "anhphim")
    private String anhphim;

    @Column(name = "trailer")
    private String trailer;
    private  Long manxb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idnxb", nullable = true)
    @JsonBackReference
    private NhaXuatBanEntity nhaXuatBan_phim;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "phim_rap",
            joinColumns = @JoinColumn(name = "phim_id"),
            inverseJoinColumns = @JoinColumn(name = "rap_id"))
    @JsonManagedReference
    private Set<RapEntity> likeRap;

    @OneToMany(mappedBy = "phim_suatChieu")
    @JsonManagedReference
    private List<SuatChieuEntity> listSuatChieu = new ArrayList<>();


    @OneToMany(mappedBy = "phim_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();

    public int gettongtien(){
        int tt = 0;
        for ( ThanhToanEntity t: this.getListThanhToan()) {
            tt += t.getTongtien();
        }
        return tt;
    }

    @OneToMany(mappedBy = "phim_danhgia_main")
    Set<DanhGiaPhimEntity> listDanhGia;
}
