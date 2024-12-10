package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Application;
// import com.wsu.workorderproservice.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, String> {
    @Query(nativeQuery = true, value ="select * from application")

    Page<Object[]> findBySearch(String search, Pageable pageable);
}