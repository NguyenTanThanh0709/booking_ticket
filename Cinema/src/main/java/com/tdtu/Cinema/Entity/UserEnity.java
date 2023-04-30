package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        }),
        @UniqueConstraint(columnNames = {
                "sdt"
        })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEnity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;


    private String email;


    private String sdt;

    @Lob
    private String avatar;

    @JsonIgnore
    private String pass;

    private int diemtich = 0;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<RolesEntity> likeRoles = new HashSet<>();



    @OneToMany(mappedBy = "user_thanhtoan")
    @JsonManagedReference
    private List<ThanhToanEntity> listThanhToan = new ArrayList<>();

    @OneToMany(mappedBy = "user_danhgia_main")
    @JsonManagedReference
    private Set<DanhGiaPhimEntity> listDanhGia;

}
