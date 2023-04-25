package com.tdtu.Cinema.Mapper;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.DTO.RoleDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RolesEntity;
import org.modelmapper.ModelMapper;

public class PhimMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static PhimEntity toEntity(PhimDTO roleDTO) {
        return modelMapper.map(roleDTO, PhimEntity.class);
    }

    public static PhimDTO toDTO(PhimEntity rolesEntity) {
        return modelMapper.map(rolesEntity, PhimDTO.class);
    }
}
