package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "hangghe")
@Data
public class HangGheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenhangghe", nullable = false, length = 50)
    private String tenHangGhe;

    @ManyToOne
    @JoinColumn(name = "idphong")
    @JsonBackReference
    private PhongChieuEntity phongChieu_hangghe;

    @OneToMany(mappedBy = "hangGhe_ghe")
    @JsonManagedReference
    private List<GheEntity> listghe = new ArrayList<>();
}
