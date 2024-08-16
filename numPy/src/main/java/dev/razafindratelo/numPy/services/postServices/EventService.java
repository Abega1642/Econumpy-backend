package dev.razafindratelo.numPy.services.postServices;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto, String userMail);
    EventDto updateEvent(String eventId,EventDto eventDto);
    EventDto getEventById(String id);
    List<EventDto> getAllEvents();
    void deleteEventById(String id);
}
