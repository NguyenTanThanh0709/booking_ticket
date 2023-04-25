package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ve")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenve;
    private String noidung;
    private int giave;

    private String trangthai;

    @OneToMany(mappedBy = "ve_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();

    public  int tongtien(){
        int t1 = 0;
        for (ThanhToanEntity t: listThanhToan
        ) {
            t1 += t.getSoluongve()*t.getVe_thanhtoan().getGiave();
        }
        return t1;
    }


}
