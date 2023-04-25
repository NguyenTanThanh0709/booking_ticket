package com.tdtu.Cinema.Service.impl;

import com.tdtu.Cinema.Entity.RolesEntity;
import com.tdtu.Cinema.Service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {
    @Override
    public Optional<RolesEntity> findByRoleName(String roleName) {
        return Optional.empty();
    }

}
