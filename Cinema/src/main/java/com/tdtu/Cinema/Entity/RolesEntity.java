package com.tdtu.Cinema.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import jakarta.persistence.*;

import java.util.*;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private  RoleName name;

    @ManyToMany(mappedBy = "likeRoles")
    @JsonManagedReference
    private Set<UserEnity> likesUser;
}
