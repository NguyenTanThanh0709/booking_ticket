package com.tdtu.Cinema.Mapper;

import com.tdtu.Cinema.DTO.UserDTO;
import com.tdtu.Cinema.Entity.UserEnity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


public class UserMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserEnity toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEnity.class);
    }

    public static UserDTO toDTO(UserEnity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
}