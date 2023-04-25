package com.tdtu.Cinema.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tdtu.Cinema.Entity.UserEnity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Long id;

    private String roleName;


}
