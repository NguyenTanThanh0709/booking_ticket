package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namefood;
    private String noidung;
    private int gia;
    private String image;
    private String trangthai;

    @OneToMany(mappedBy = "food_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();

    public int tongtien(){
        int t1 = 0;
        for (ThanhToanEntity t: listThanhToan
             ) {
            t1 += t.getSoluongfood()*t.getFood_thanhtoan().getGia();
        }
        return t1;
    }
}
