package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.RapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapRepositoty extends JpaRepository<RapEntity,Long> {

}
