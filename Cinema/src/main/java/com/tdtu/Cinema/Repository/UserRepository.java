package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.UserEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEnity, Long> {
    Optional<UserEnity> findByEmail(String email);
    Boolean existsByEmail(String email);
    List<UserEnity> findByEmailAndPass(String email, String pass);
}
