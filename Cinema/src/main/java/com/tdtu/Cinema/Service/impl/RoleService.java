package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.RoleName;
import com.tdtu.Cinema.Entity.RolesEntity;
import com.tdtu.Cinema.Repository.RoleRepository;
import com.tdtu.Cinema.Service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<RolesEntity> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
