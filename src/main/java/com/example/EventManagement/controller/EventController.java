package com.example.EventManagement.controller;

import com.example.EventManagement.model.Events;
import com.example.EventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    EventService eventService;

    @PutMapping("/event")
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        return null;
    }

}
