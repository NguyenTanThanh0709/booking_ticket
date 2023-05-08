package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.DTO.RoleDTO;
import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.RoleName;
import com.tdtu.Cinema.Entity.RolesEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import com.tdtu.Cinema.Mapper.RoleMapper;
import com.tdtu.Cinema.Mapper.UserMapper;
import com.tdtu.Cinema.Repository.RoleRepository;
import com.tdtu.Cinema.Repository.UserRepository;
import com.tdtu.Cinema.Service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO getbyemail(String email) {

        return UserMapper.toDTO(userRepository.findByEmail(email).get());
    }

    @Override
    public UserEnity getonrbyid(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserDTO> getall() {
        List<UserDTO> list = new ArrayList<>();
        List<UserEnity> l = userRepository.findAll();
        for (UserEnity u :l) {
            list.add(UserMapper.toDTO(u));
        }
        return list;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEnity userEntity = UserMapper.toEntity(user);
        if(user.getId() != null){
            UserEnity usertemp = userRepository.findByEmail(user.getEmail()).get();
            userEntity.setLikeRoles(usertemp.getLikeRoles());
            userEntity.setListDanhGia(usertemp.getListDanhGia());
            userEntity.setListThanhToan(usertemp.getListThanhToan());
            //userEntity.setListVe(usertemp.getListVe());
        }else{
            RolesEntity role = roleRepository.findByName(RoleName.USER).get();
            Set<RolesEntity> listrole = new HashSet<>();
            listrole.add(role);
            userEntity.setLikeRoles(listrole);
        }
        return UserMapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public UserEnity save(UserEnity user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO login(String email, String pass) {
        return UserMapper.toDTO(userRepository.findByEmailAndPass(email,pass).get(0));
    }

    @Override
    public Optional<UserEnity> findBySdt(String sdt) {
        return userRepository.findBySdt(sdt);
    }

    @Override
    public Boolean existsBySdt(String sdt) {
        return userRepository.existsBySdt(sdt) ;
    }

    @Override
    public List<UserEnity> findBySdtAndPass(String sdt, String pass) {
        return userRepository.findBySdtAndPass(sdt,pass);
    }

}
