package com.tdtu.Cinema.Mapper;

import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.DTO.RapDTO;
import com.tdtu.Cinema.Entity.PhimEntity;
import com.tdtu.Cinema.Entity.RapEntity;
import org.modelmapper.ModelMapper;

public class RapMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static RapEntity toEntity(RapDTO roleDTO) {
        return modelMapper.map(roleDTO, RapEntity.class);
    }

    public static RapDTO toDTO(RapEntity rolesEntity) {
        return modelMapper.map(rolesEntity, RapDTO.class);
    }
}
