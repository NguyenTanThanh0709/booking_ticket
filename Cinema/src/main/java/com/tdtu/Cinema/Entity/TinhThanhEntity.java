package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tinhthanh")
@Data
public class TinhThanhEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tentinhthanh", nullable = false, length = 50)
    private String tenTinhThanh;

    @OneToMany(mappedBy = "tinhThanh_rap")
    @JsonManagedReference
    private List<RapEntity> listRaps = new ArrayList<>();
}
