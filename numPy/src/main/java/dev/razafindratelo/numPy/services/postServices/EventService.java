package dev.razafindratelo.numPy.services.postServices;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.entity.user.User;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto, User user);
    EventDto updateEvent(String eventId,EventDto eventDto);
    EventDto getEventById(String id);
    List<EventDto> getAllEvents();
    void deleteEventById(String id);
}
