package com.tdtu.Cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtReponse {
    private String token;
    private  String type = "Bearer";
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtReponse(String token, String name, Collection<? extends GrantedAuthority> roles){
        this.token = token;
        this.name = name;
        this.roles = roles;
    }

}
