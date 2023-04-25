package com.tdtu.Cinema.Mapper;

import com.tdtu.Cinema.DTO.NxbDTO;
import com.tdtu.Cinema.DTO.PhimDTO;
import com.tdtu.Cinema.Entity.NhaXuatBanEntity;
import com.tdtu.Cinema.Entity.PhimEntity;
import org.modelmapper.ModelMapper;

public class NXBMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static NhaXuatBanEntity toEntity(NxbDTO roleDTO) {
        return modelMapper.map(roleDTO, NhaXuatBanEntity.class);
    }

    public static NxbDTO toDTO(NhaXuatBanEntity rolesEntity) {
        return modelMapper.map(rolesEntity, NxbDTO.class);
    }
}
