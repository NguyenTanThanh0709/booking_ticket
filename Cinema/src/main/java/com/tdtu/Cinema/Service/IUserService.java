package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.UserEnity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserDTO getbyemail(String email);
    UserEnity getonrbyid(Long id);
    List<UserDTO> getall();
    Boolean existsByEmail(String email);
    UserDTO save(UserDTO user);
    UserDTO login(String email, String pass);

    Optional<UserEnity> findBySdt(String sdt);
    Boolean existsBySdt(String sdt);
    List<UserEnity> findBySdtAndPass(String sdt, String pass);


}
