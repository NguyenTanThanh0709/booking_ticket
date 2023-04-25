package com.tdtu.Cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhimDTO {
    private Long id;
    private String tenphim;
    private int tuoi;
    private String theloai;
    private String quocgia;
    private String dienvien;
    private String daodien;
    private String ngaychieu;
    private int rating = 0;
    private int thoiluong;
    private String loaiphim;
    private String noidung;
    private String trangthai;

    private String anhphim;

    private String trailer;
    private  Long manxb;
}
