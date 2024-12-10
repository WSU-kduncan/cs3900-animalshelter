package com.wsu.workorderproservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wsu.workorderproservice.model.Pet;

public interface  PetRepository extends JpaRepository<Pet, Integer> {

    @Query("SELECT p.petId, p.petName, p.species, p.breed, p.sex, p.weight, p.age, p.intakeDate, p.status " +
        "FROM Pet p " +
        "WHERE (:search IS NULL OR LOWER(p.petName) LIKE LOWER(CONCAT('%', :search, '%')) " +
        "OR LOWER(p.breed) LIKE LOWER(CONCAT('%', :search, '%')) " +
        "OR LOWER(p.species) LIKE LOWER(CONCAT('%', :search, '%'))) ")
    Page<Object[]> findBySearch(String search, PageRequest pageRequest);
    // List<Pet> findByStatus(String status);
    // List<Pet> findByDistinctPetName(String petName);
    // List<Pet> findByDistinctBreed(String breed);
}
