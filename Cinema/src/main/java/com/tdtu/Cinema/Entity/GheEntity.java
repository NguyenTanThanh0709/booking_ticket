package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ghe")
@Data
public class GheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trangthai", nullable = false, length = 50)
    @Check(constraints = "trangthai in ('1', '0')")
    private String trangThai;

    @Column(name = "tenghe")
    private Integer tenGhe;

    @ManyToOne
    @JoinColumn(name = "idhangghe")
    @JsonBackReference
    private HangGheEntity hangGhe_ghe;




    @OneToMany(mappedBy = "ghe_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();
}
