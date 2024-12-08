package com.wsu.workorderproservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "staff")

public class Staff {
    @Id
    @Column(name = "staff_id")
    private Integer staffCode;

    @Column(name = "staff_first_name")
    private String firstName;

    @Column(name = "staff_last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "phone_number")
    private String phone;
}
