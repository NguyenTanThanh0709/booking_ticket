package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nhaxuatban")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaXuatBanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tennhaxuatban;
    private  String trangthai;
    @OneToMany(mappedBy = "nhaXuatBan_phim")
    @JsonManagedReference
    private List<PhimEntity> listPhims = new ArrayList<>();
}
