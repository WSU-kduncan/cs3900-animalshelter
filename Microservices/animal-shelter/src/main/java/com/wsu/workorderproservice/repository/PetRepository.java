package com.wsu.workorderproservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wsu.workorderproservice.model.Pet;

public interface  PetRepository extends JpaRepository<Pet, Integer> {

    @Query("SELECT p.pet_ID AS id, p.pet_name AS name, p.species AS species, p.breed AS breed, p.sex AS sex, p.weight AS weight, p.age AS age, p.intake_date AS date, p.pet_status AS pet_status " +
           "FROM Pet p " +
           "WHERE :search IS NULL OR (p.pet_name = :search)) ")
    Page<Object[]> findBySearch(String search, PageRequest pageRequest);
    // List<Pet> findByStatus(String status);
    // List<Pet> findByDistinctPetName(String petName);
    // List<Pet> findByDistinctBreed(String breed);
}
