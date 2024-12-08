package com.wsu.workorderproservice.model;

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
@Table(name = "Pet")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "pet_name") //Add default name if null
    private String petName;

    @Column(name = "species") //Cat or Dog, can't be null
    private String species;

    @Column(name = "breed") //add default mutt
    private String breed;

    @Column(name = "sex") //male or female, can't be null
    private String sex;

    @Column(name = "weight") //can be null
    private Integer weight;

    @Column(name = "age") //add default "unknown" if null
    private String age; 

    @Column(name = "intake_date") 
    private Date intakeDate; //date pet joined shelter

    @Column(name = "pet_status")private String status; //status of pet if adopted or not

}
