package com.tdtu.Cinema.Entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGiaPhimId implements Serializable {

    private Long user_danhgia;
    private Long phim_danhgia;

    // getters and setters

}