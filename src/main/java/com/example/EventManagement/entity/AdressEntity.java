package com.example.EventManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AdressEntity {

    public AdressEntity(String country, String street, String city, String houseNumber) {
        
    }

    @Id
    private Long id;

    private String country;
    private String street;
    private String city;
    private String houseNumber;
}
