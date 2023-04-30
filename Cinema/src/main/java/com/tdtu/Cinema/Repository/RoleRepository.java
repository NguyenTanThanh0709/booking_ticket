package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.RoleName;
import com.tdtu.Cinema.Entity.RolesEntity;
import com.tdtu.Cinema.Entity.UserEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
    Optional<RolesEntity> findByName(RoleName name);
}
