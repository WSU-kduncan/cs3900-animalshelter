package com.wsu.workorderproservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdopterDTO {
    
    @NotBlank(message = "Adopter ID cannot be null or blank")
    private Integer adopterId;
    @NotBlank(message = "Name cannot be null or blank")
    private String name;
    @NotBlank(message = "Email cannot be null or blank")
    private String email;
    @NotBlank(message = "Registration date cannot be null or blank")
    private Date registrationDate;
    @NotBlank(message = "Phone number cannot be null or blank")
    @Size(max = 11)
    private String phoneNumber;
}
