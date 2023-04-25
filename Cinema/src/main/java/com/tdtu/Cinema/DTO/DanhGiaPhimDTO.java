package com.tdtu.Cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGiaPhimDTO {
    private String tieude;
    private String danhgia;

    private Long user_danhgia;

    private Long phim_danhgia;
}
