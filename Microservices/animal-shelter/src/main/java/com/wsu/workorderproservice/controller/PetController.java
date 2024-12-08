package com.wsu.workorderproservice.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsu.workorderproservice.dto.PetDTO;
import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.service.PetService;
import com.wsu.workorderproservice.utilities.Constants;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;
import static com.wsu.workorderproservice.utilities.Constants.PAGE_COUNT;
import static com.wsu.workorderproservice.utilities.Constants.RESULT_COUNT;


//@RestController is used when you want to return data (e.g. JSON or XML) rather than a view (HTML). @ RestController is basically a meta-annotation that combines @Controller and @ResponseBody
@RestController
//@RequiredArgsConstructor is a Lombok annotation that generates constructors for all final and non-null fields.
@RequiredArgsConstructor
//@RequestMapping annotation is used to map requests URI to controllers / methods.
@RequestMapping("/pets")

public class PetController {

    private final PetService petService;


    @GetMapping
    /* Used to retrieve a Pet based on filters
     * search - allow to filter pets based on age, breed, length of stay, name
     * @param page - no. of page (default 1)
     * @param rpp - results per page (default 10)
     * @param sortField - sort field for sorting the results (default dateLastUpdated)
     * @param sortOrder - sort order (default desc)
     * @return - list of pets that's matched given criteria
    */
    public ResponseEntity<ServiceResponseDTO> getPets(@RequestParam(required = false)String search,
                                                @RequestParam(required = false, defaultValue = "1") Integer page,
                                                @RequestParam(required = false, defaultValue = "10") Integer rpp,
                                                @RequestParam(required = false, defaultValue = "intakeDate") String sortField,
                                                @RequestParam(required = false, defaultValue = Constants.DESC) String sortOrder) {
                                                    Page<PetDTO> petDTOPage = petService.get(search, sortField, sortOrder, page, rpp);
    return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Petss retrieved successfully.", PAGE_COUNT,
            petDTOPage.getTotalPages(), RESULT_COUNT, petDTOPage.getTotalElements())).data(petDTOPage.getContent())
            .build(), HttpStatus.OK);
    }
    //Add constants
    //Make get method in petService to (String, String, String, Integer, Integer)

    
    /*Method to add new pet if it doesn't already exist */
        /**
     * This endpoint used for create new pet in database.
     * @param petDTO - payload that contains pet information
     * @return - ServiceResponseDTO which include HTTP status and pet details.
     */
    //@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST)
    //@RequestBody annotation is applicable to handler methods of Spring controllers.
    // This annotation indicates that Spring should deserialize a request body into an object. This object is passed as a handler method parameter.
    //@Valid annotation is a standard Java annotation for bean validation
    @PostMapping
    public ResponseEntity<ServiceResponseDTO> save(@RequestBody @Valid PetDTO petDTO) {
        if (petDTO.getPetId() == null) {
            throw new InvalidRequestException("Pet Id must be provided.");
        }
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Successfully added technician"))
                .data(petService.save(petDTO)).build(), HttpStatus.CREATED);
    }

    //need to add exceptions
    //create save method in PetService


    
    /*This method is used to update Pet */
    /*Another method to also deactivate a pet */
        /**
     * This endpoint used for update the pet by pet id
     * @param petId - pet id
     * @param petDTO - payload that contains updated pet info
     * @return - HTTP status including updated pet dto
     */
    //The @PutMapping annotation is a Spring annotation that maps HTTP PUT requests to specific handler methods in RESTful web service
    @PutMapping("/{petId}")
    public ResponseEntity<ServiceResponseDTO> update(@PathVariable Integer petId, @RequestBody @Valid PetDTO petDTO) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, "Pet updated successfully"))
                .data(petService.update(petId, petDTO)).build(), HttpStatus.OK);
    }

    

    //add update method in PetService

    /*Another method to also deactivate a pet */


}
