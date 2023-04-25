package com.tdtu.Cinema.Entity;


import lombok.*;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "khuyenmai")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenkhuyenmai;
    private String img;
    private int tienkhuyenmai;
    private String trangthai;
}
