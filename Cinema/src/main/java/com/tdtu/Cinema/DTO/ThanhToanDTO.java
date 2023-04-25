package com.tdtu.Cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThanhToanDTO {
    private Long idSuatchieu;
    private Long idUser;
    private Long idFood;
    private Long idVe;
    private long[] idGhe;
    private int tongtien ;
    private int soluongfood;

    private String ngay;
}
