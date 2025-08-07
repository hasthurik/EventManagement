package com.example.EventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class Location {

    @Id
    Long Id;

    String name;
}
