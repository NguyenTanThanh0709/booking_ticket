package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "danhgiaphim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGiaPhimEntity {

    @EmbeddedId
    private DanhGiaPhimId id;

    @ManyToOne
    @MapsId("user_danhgia")
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEnity user_danhgia_main;


    @ManyToOne
    @MapsId("phim_danhgia")
    @JoinColumn(name = "phim_danhgia")
    @JsonBackReference
    private PhimEntity phim_danhgia_main;



    @Column(name = "danhgia", nullable = false,  columnDefinition = "TEXT")
    private String danhGia;

    private String tieude;
}
