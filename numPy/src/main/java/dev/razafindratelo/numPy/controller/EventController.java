package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.dtos.userDtos.IndividualDto;
import dev.razafindratelo.numPy.dtos.userDtos.OrganizationDto;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.mapper.postMapper.EventMapper;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import dev.razafindratelo.numPy.services.postServices.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EventController {

    EventService eventService;
    IndividualService individualService;
    OrganizationService organizationService;

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

    @PostMapping("/event/add/{userMail}")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto, @PathVariable ("userMail")String userMail) {
        IndividualDto individual = individualService.getIndividualById(userMail);
        OrganizationDto organization = organizationService.getOrganizationById(userMail);
        EventDto addEvent;
        if (individual == null) {
            addEvent = eventService.createEvent(eventDto, IndividualMapper.toIndividual2());

        } else if (organization == null) {
            addEvent = eventService.createEvent(eventDto, OrganizationMapper.toOrganization2());
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
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
