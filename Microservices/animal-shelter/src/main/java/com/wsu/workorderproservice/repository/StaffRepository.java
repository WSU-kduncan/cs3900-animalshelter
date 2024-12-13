package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query(nativeQuery = true, value ="some Sql query here")

    Page<Object[]> findBySearch(String search, Pageable pageable);
}
