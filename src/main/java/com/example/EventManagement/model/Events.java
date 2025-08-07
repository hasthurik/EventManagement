package com.example.EventManagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class Events {

    @Id
    Long Id;

    String name;
}
