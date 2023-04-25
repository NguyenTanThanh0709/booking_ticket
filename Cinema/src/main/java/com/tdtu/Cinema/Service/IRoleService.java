package com.tdtu.Cinema.Service;

import com.tdtu.Cinema.Entity.RolesEntity;

import java.util.Optional;

public interface IRoleService {
    Optional<RolesEntity> findByRoleName(String roleName);
}
