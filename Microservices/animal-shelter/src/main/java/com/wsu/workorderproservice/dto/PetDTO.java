package com.wsu.workorderproservice.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date; 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PetDTO {

    private Integer petId;
    
    //Pet name needs a default value
    @Builder.Default
    private String petName = "Undecided";

    @NotBlank(message = "Species must not be null or blank")
    private String species;

    //if empty field needs default values of "mutt"
    @Builder.Default
    private String breed = "mutt";

    @NotBlank(message = "Sex must not be null or blank")
    private String sex;

    @NotNull(message = "Weight must not be null or blank")
    private Integer weight;

    //if empty field needs default value of "Unkown"
    @Builder.Default
    private String age = "Unknown"; 

    @NotNull(message = "Date must not be null or blank")
    private Date intakeDate; //date pet joined shelter

    @Builder.Default
    private String status = "Not Adopted";

}
