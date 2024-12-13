package com.wsu.workorderproservice.controller;
import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.dto.StaffDTO;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.utilities.Constants;
import com.wsu.workorderproservice.service.StaffService;

import java.util.Map;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;
import static com.wsu.workorderproservice.utilities.Constants.PAGE_COUNT;
import static com.wsu.workorderproservice.utilities.Constants.RESULT_COUNT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping 
    public ResponseEntity<ServiceResponseDTO> getAllStaff(
        @RequestParam(required = false) String search,
        @RequestParam(required = false, defaultValue = "1") Integer page,
        @RequestParam(required = false, defaultValue = "10") Integer rpp,
        @RequestParam(required = false, defaultValue = "staffCode") String sortField,
        @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder){

        Page<StaffDTO> staffDTOPage = staffService.get(search,sortField,sortOrder,page,rpp);
            return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Successfully retrieved staffs.", PAGE_COUNT,
                        staffDTOPage.getTotalPages(), RESULT_COUNT, staffDTOPage.getTotalElements()))
                .data(staffDTOPage.getContent()).build(), HttpStatus.OK);
    }

    @PostMapping //will be used to add new applications to the system
    public ResponseEntity<ServiceResponseDTO> save(@RequestBody @Valid StaffDTO staffDTO){
        if(!StringUtils.hasLength(staffDTO.getStaffCode().toString())){
            throw new InvalidRequestException("Staff code must be provided");
        }
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Successfully added staff"))
        .data(staffService.save(staffDTO)).build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}") //Will be used to update the status of and information in applications already existing in the system
    public ResponseEntity<ServiceResponseDTO> update(@PathVariable Integer id, @RequestBody @Valid StaffDTO staffDTO) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "staff updated successfully"))
                .data(staffService.update(id, staffDTO)).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<ServiceResponseDTO> deleteStaff(@PathVariable Integer code) {
        staffService.delete(code);
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "staff deleted successfully")).build(), HttpStatus.OK);
    }
}
