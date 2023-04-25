package com.tdtu.Cinema.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tdtu.Cinema.Entity.RolesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String user;
    private String email;
    private String sdt;
    private String avatar;
    private String pass;
    private int diemtich = 0;
}
