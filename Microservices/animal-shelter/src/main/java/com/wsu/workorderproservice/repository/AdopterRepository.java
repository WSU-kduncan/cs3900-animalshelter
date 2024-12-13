package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Adopter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
    @Query(nativeQuery = true, value ="select * from adopter where adapter.id == %:search%")

    Page<Object[]> findBySearch(String search, Pageable pageable);
}