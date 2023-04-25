package com.tdtu.Cinema.Mapper;

import com.tdtu.Cinema.DTO.RoleDTO;
import com.tdtu.Cinema.Entity.RolesEntity;
import org.modelmapper.ModelMapper;

public class RoleMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static RolesEntity toEntity(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, RolesEntity.class);
    }

    public static RoleDTO toDTO(RolesEntity rolesEntity) {
        return modelMapper.map(rolesEntity, RoleDTO.class);
    }
}