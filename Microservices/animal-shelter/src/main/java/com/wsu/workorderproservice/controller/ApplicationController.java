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
import com.wsu.workorderproservice.model.Application;
import com.wsu.workorderproservice.service.ApplicationService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
    
    private final ApplicationService applicationService;

    @GetMapping(value = "{application_id}")
    public ResponseEntity<ServiceResponseDTO> getApplication(@PathVariable String application_id) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Application retrieved successfully")).data(applicationService.get(application_id)).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> addApplication(@RequestBody Application application) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Application added successfully")).data(applicationService.add(application)).build(), HttpStatus.CREATED);
    }

    @PutMapping(value = "{application_id}")
    public ResponseEntity<ServiceResponseDTO> updateApplication(@PathVariable String application_id, @RequestBody Application application) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Application updated successfully")).data(applicationService.update(application_id, application)).build(), HttpStatus.OK);
    }
}
