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
public class ApplicationDTO {
    
    @NotBlank(message = "Application ID cannot be null or blank")
    private Integer applicationId;
    @NotBlank(message = "Pet ID cannot be null or blank")
    private Integer petId;
    @NotBlank(message = "Adopter ID cannot be null or blank")
    private Integer adopterId;
    @NotBlank(message = "Application date cannot be null or blank")
    private Date appliationDate;
    @NotBlank(message = "Application status cannot be null or blank")
    @Size(max = 15)
    private String applicationStatus;
}
