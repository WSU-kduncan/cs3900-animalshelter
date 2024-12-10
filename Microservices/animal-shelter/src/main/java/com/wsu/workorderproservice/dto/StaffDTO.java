package com.wsu.workorderproservice.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

@Builder

public class StaffDTO {

    private Integer staffCode;
    @NotBlank(message = "First name must not be null or blank")
    private String firstName;

    @NotBlank(message = "Last name must not be null or blank")
    private String lastName;

    @NotBlank(message = "Position cannot be blank or null")
    private String position;

    @NotBlank(message = "Phone number cannot be blank")
    private String phone;

}
