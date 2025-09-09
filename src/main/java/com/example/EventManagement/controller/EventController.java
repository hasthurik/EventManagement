package com.example.EventManagement.controller;

import com.example.EventManagement.entity.EventEntity;
import com.example.EventManagement.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    //Создание нового события
    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@RequestBody EventEntity event) {
        EventEntity savedEvent = eventService.saveEvent(event);
        if(savedEvent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }
    //получние по id
    @GetMapping("/{id}")
    public ResponseEntity<EventEntity> getById(@PathVariable Long id) {
        EventEntity event = eventService.getEventById(id);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //удаление ивента по id
    @DeleteMapping("/{id}")
    public ResponseEntity<EventEntity> deleteUser(@PathVariable Long id) {
        if (eventService.getEventById(id) != null) {
            eventService.deleteUserById(id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping
    public ResponseEntity<EventEntity> updateEvent(@RequestBody EventEntity event) {
        EventEntity eventEntity = eventService.getEventById(event.getId());
        if (eventEntity != null) {

        }
        return null;
    }

}
