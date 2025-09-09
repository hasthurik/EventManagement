package com.example.EventManagement.service;

import com.example.EventManagement.entity.EventEntity;
import com.example.EventManagement.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    private final EventRepository eventRepo;

    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    public EventEntity saveEvent(EventEntity event) {
        //проверка корректности даты и времени
        LocalDateTime time = event.getTime();
        if(time != null && time.isAfter(LocalDateTime.now())) {
            return eventRepo.save(event);
        }
        else {
            return null;
        }
    }

    //получение плоьзователя по id
    public EventEntity getEventById(Long id) {
        return eventRepo.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        eventRepo.deleteById(id);
    }
}
