package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.dto.StaffDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.Staff;
import com.wsu.workorderproservice.repository.StaffRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

import static com.wsu.workorderproservice.utilities.CommonUtils.sort;


@Service
@RequiredArgsConstructor
@Slf4j

public class StaffService {

    private final StaffRepository staffRepository;
    
    public Page<StaffDTO> get(String search, String sortField, String sortOrder, Integer page, Integer rpp){
        try {
            Page<Object[]> staff = staffRepository.findBySearch(search, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)));
            return staff.map(stave -> StaffDTO.builder().staffCode((Integer)stave[0])
            .firstName((String)stave[1])
            .lastName((String)stave[2])
            .position((String)stave[3])
            .phone((String)stave[4]).build());
        } catch (Exception e) {
            log.error("Failed to retrieve Staff. search:{}, sortField:{}, sortOrder:{}, page:{}, rpp:{}, Exception:{}",
            search, sortField, sortOrder, page, rpp, e);
            throw new DatabaseErrorException("Failed to retrieve staffs", e);
        }
    }

    /**
     * Creates a new Staff entity when given a valid Staff DTO.
     * @param staffDTO - used to create new Staff object.
     * @return - returns the saved StaffDTO object from the persisted Staff entity.
     */
    public StaffDTO save(StaffDTO staffDTO){
        if(staffRepository.existsById(staffDTO.getStaffCode())){
            throw new InvalidRequestException("Staff member already exists by this code");
        }
        try {
            Staff staff = mapToEntity(staffDTO);
            staff.setStaffCode(staffDTO.getStaffCode());
            return mapToDto(staffRepository.save(staff));
        } catch (Exception e) {
            log.error("Failed to add Staff member. staff code:{}, Exception:{}", staffDTO.getStaffCode(), e);
            throw new DatabaseErrorException("Failed to add Staff member.", e);
        }
    }
    
    /**
     * This method is used for updateding staff via their staff code
     * @param staffCode - identifies the desiried staff for updating
     * @param staffDTO - Holds the staff info
     * @return - returns an updated staff entity class
     */
    public Staff update(Integer staffCode, StaffDTO staffDTO){
        
        if(!staffRepository.existsById(staffCode)){
            throw new InvalidRequestException("Invalid Staff code.");
        }

        try {
            Staff staff = mapToEntity(staffDTO);
            staff.setStaffCode(staffCode);
            return staffRepository.save(staff);
        } catch (Exception e) {
            log.error("Failed to update staff, staffCode:{}. Exception:", staffCode, e);
            throw new DatabaseErrorException("Failed to update staff", e);
        }
    }


    /**
     * Will disable and archive staff data for access by management for reference later should it be needed
     */
    public void delete(Integer staffCode){
        if(!staffRepository.existsById(staffCode)){
            throw new InvalidRequestException("Invalid Staff code.");
        }
        try {
            staffRepository.deleteById(staffCode);// You had suggested something about deactivating the data instead of delteing it I could not find anything about how to do that
        } catch (Exception e) {                       // if you could in your feedback expand on how to do somehow disable this data instead of delete it Id appreciate it 
            log.error("Failed to deactivate Staff, staffCode:{}. Exception:{}", staffCode, e);
            throw new DatabaseErrorException("Failed to delete staff", e);
        } 
    }

    /**
     * This method used to convert DTO to entity model class.
     */
    private Staff mapToEntity(StaffDTO staffDTO) {
        Staff staff = Staff.builder()
            .firstName(staffDTO.getFirstName())
            .lastName(staffDTO.getLastName())
            .position(staffDTO.getPosition())
            .phone(staffDTO.getPhone()).build();
        return staff;
    }

    /**
     * This method used to convert Entity model class to DTO class.
     */
    private StaffDTO mapToDto(Staff staff) {
        return  staff != null ? StaffDTO.builder().staffCode(staff.getStaffCode())
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .position(staff.getPosition())
                .phone(staff.getPhone()).build() : null;
    }

}
