package com.tdtu.Cinema.Repository;

import com.tdtu.Cinema.Entity.PhimEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhimepositoryPaging extends PagingAndSortingRepository<PhimEntity, Long> {
    Page<PhimEntity> findAll(Pageable pageable);
}
