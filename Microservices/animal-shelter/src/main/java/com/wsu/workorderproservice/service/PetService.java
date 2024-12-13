package com.wsu.workorderproservice.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.dto.PetDTO;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.model.Pet;
import com.wsu.workorderproservice.repository.PetRepository;





import static com.wsu.workorderproservice.utilities.CommonUtils.sort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Service annotation is used to mark a class as a service provider that contains business logic
@Service
//@RequiredArgsConstructor is a Lombok annotation that generates constructors for all final and non-null fields.
@RequiredArgsConstructor
//@Slf4j is a logging annotation for Spring Boot applications that creates a static SLF4J logger instance when applied to a class
@Slf4j

public class PetService {

    private final PetRepository petRepository;


        /**
     * This method used to retrieve a page of pets.
     * @param search - allows for type ahead search by pet attributes
     * @param sortField - field used for sorting result, default value is pet id.
     * @param sortOrder - specifies order for the returned result, Default value is descending.
     * @param page - specifies which page result have to return
     * @param rpp - specifies how many records have to return on page.
     * @return - Returns Page<PetDTO> mapped from the Page<Object[]> returned from the database.
     */
    public Page<PetDTO> get(String search, String sortField, String sortOrder, Integer page, Integer rpp) {
        try {
            Page<Object[]> pets = petRepository.findBySearch(search, PageRequest.of(page-1, rpp, sort(sortField, sortOrder)));
            return pets.map(pet -> PetDTO.builder().petId((Integer) pet[0])
                    .petName((String) pet[1])
                    .species((String) pet[2])
                    .breed((String) pet[3])
                    .sex((String) pet[4])
                    .weight((Integer) pet[5])
                    .age((String) pet[6])
                    .intakeDate((Date) pet[7])
                    .status((String) pet[8])
                    .build());
        } catch (Exception e) { //Throws database error exception if any exception occurs. We are using ControllerExceptionHandler to handle it.
            log.error("Failed to retrieve pets. search:{}, sortField:{}, sortOrder:{}, page:{}, rpp:{}, Exception:{}",
                    search, sortField, sortOrder, page, rpp, e);
            throw new DatabaseErrorException("Failed to retrieve pets", e);
            //need to add database error exception
        }
    }

        /**
     * Creates a new Pet entity when given a valid PetDTO.
     * @param petDTO - used to create new pet object.
     * @return - returns the saved PetDTO object from the persisted Pet entity.
     * figure out how to make this code work for an Integer and not a string
     */
    public PetDTO save(PetDTO petDTO) {
        if (petRepository.existsById(petDTO.getPetId())) {
            throw new InvalidRequestException("Pet already exist with this ID.");
        }
        try {
            Pet pet = mapToEntity(petDTO);
            pet.setPetId(petDTO.getPetId());
            return mapToDto(petRepository.save(pet));
        } catch (Exception e) {
            log.error("Failed to add pet. pet code:{}, Exception:{}", petDTO.getPetId(), e);
            throw new DatabaseErrorException("Failed to add pet.", e);
        }
    }


        /**
     * This method used for update pet by pet id
     * @param petId - identifier used to update desired pet
     * @param petDTO - payload that contains pet info to be updated
     * @return - updated pet entity class
     */
    public Pet update(Integer petId, PetDTO petDTO) {
        if (!petRepository.existsById(petId)) {
            throw new InvalidRequestException("Pet already Exists!");
        }
        try {
            Pet pet = mapToEntity(petDTO);
            pet.setPetId(petId);
            return petRepository.save(pet);
        } catch (Exception e) {
            log.error("Failed to update pet, petId:{}. Exception:", petId, e);
            throw new DatabaseErrorException("Failed to update pet", e);
        }
    }

            /**
     * This method used to convert DTO to entity model class.
     */
    private Pet mapToEntity(PetDTO petDTO) {
        Pet pet = Pet.builder()
        .petId(petDTO.getPetId())
        .petName(petDTO.getPetName())
        .species(petDTO.getSpecies())
        .breed(petDTO.getBreed())
        .sex(petDTO.getSex())
        .weight(petDTO.getWeight())
        .age(petDTO.getAge())
        .intakeDate(petDTO.getIntakeDate())
        .status(petDTO.getStatus())
        .build();

        return pet;
    }


    
    /**
     * This method used to convert Entity model class to DTO class.
     */
    private PetDTO mapToDto(Pet pet) {
        return  pet != null ? PetDTO.builder()
        .petId(pet.getPetId())
        .petName(pet.getPetName())
        .species(pet.getSpecies())
        .breed(pet.getBreed())
        .sex(pet.getSex())
        .weight(pet.getWeight())
        .age(pet.getAge())
        .intakeDate(pet.getIntakeDate())
        .status(pet.getStatus())

        .build() : null;
    }

    

}
