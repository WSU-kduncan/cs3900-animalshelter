package com.wsu.workorderproservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.model.Adopter;
import com.wsu.workorderproservice.service.AdopterService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adopter")
public class AdopterController {
    
    private final AdopterService adopterService;

    @GetMapping(value = "{adopter_id}")
    public ResponseEntity<ServiceResponseDTO> getAdopter(@PathVariable Integer adopter_id) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Adopter retrieved successfully")).data(adopterService.get(adopter_id)).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> addAdopter(@RequestBody Adopter adopter) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Adopter added successfully")).data(adopterService.add(adopter)).build(), HttpStatus.CREATED);
    }

    @PutMapping(value = "{adopter_id}")
    public ResponseEntity<ServiceResponseDTO> updateAdopter(@PathVariable Integer adopter_id, @RequestBody Adopter adopter) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Adopter updated successfully")).data(adopterService.update(adopter_id, adopter)).build(), HttpStatus.OK);
    }
}
