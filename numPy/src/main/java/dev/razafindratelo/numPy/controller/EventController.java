package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.services.userServices.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EventController {

    private EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> getEvents() {
        List<EventDto> eventDtoList = eventService.getAllEvents();
        return ResponseEntity.ok(eventDtoList);
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<PostDto> getEvent(@PathVariable String eventId) {
        EventDto eventDto = eventService.getEventById(eventId);
        return ResponseEntity.ok(eventDto);
    }

    @PostMapping("/event/add")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto) {
        EventDto addEvent = eventService.createEvent(eventDto);
        return new ResponseEntity<>(addEvent, HttpStatus.CREATED);
    }

    @PutMapping("/event/update/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("eventId") String eventId, @RequestBody EventDto eventDto) {
        EventDto updateEvent = eventService.updateEvent(eventId, eventDto);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @DeleteMapping("/event/delete/{eventId}")
    public String deleteUser(@PathVariable("eventId") String  eventId) {
        eventService.deleteEventById(eventId);
        return "Event deleted with success !";
    }

}
