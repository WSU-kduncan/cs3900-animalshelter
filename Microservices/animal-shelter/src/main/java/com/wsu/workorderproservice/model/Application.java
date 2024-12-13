package com.wsu.workorderproservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "adopter_application")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;
    @Column(name = "pet_id")
    private Integer petId;
    @Column(name = "adopter_id")
    private Integer adopterId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "application_date")
    private Date appliationDate;
    @Column(name = "application_status")
    private String applicationStatus;
}
