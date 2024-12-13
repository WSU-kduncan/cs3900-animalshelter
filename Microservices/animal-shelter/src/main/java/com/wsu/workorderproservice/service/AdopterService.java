package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.model.Adopter;
import com.wsu.workorderproservice.repository.AdopterRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdopterService {
    
    private static final Logger log = LoggerFactory.getLogger(AdopterService.class);
    private final AdopterRepository adopterRepository;

    public Adopter get(Integer adopter_id) {
        Optional<Adopter> adopter = adopterRepository.findById(adopter_id);
        if (adopter.isEmpty()) {
            throw new InvalidRequestException("Invalid adopter ID");
        } 
        try {
            return adopterRepository.findById(adopter_id).orElse(null);
        } catch (Exception e) {
            log.error("Failed to retrieve adopter details. adpoter_id:{}, Exception:{}", adopter_id, e);
            throw new DatabaseErrorException("Failed to retrieve adopter details.", e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Adopter add(Adopter adopter) {
        try {
            return adopterRepository.save(adopter);
        } catch (Exception e) {
            log.error("Failed to add adopter. Exception: ", e);
            throw new DatabaseErrorException("Failed to add adopter", e);
        }
    }

    @Transactional(rollbackOn = Exception.class) 
    public Adopter update(Integer adopter_id, Adopter adopter) {
        Optional<Adopter> adopterResp = adopterRepository.findById(adopter_id);
        if (adopterResp.isEmpty()) {
            throw new InvalidRequestException("Invalid adopter ID");
        }
        
        try {
            return adopterRepository.save(adopter);
        } catch (Exception e) {
            log.error("Failed to update adopter. adopter_id:{}, Exception:{}", adopter_id, e);
            throw new DatabaseErrorException("Failed to update adopter.", e);
        }
    }
}
