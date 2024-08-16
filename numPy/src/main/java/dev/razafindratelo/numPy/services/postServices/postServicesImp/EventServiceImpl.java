package dev.razafindratelo.numPy.services.postServices.postServicesImp;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.services.postServices.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    @Override
    public EventDto createEvent(EventDto eventDto) {
        return null;
    }

    @Override
    public EventDto updateEvent(String eventId, EventDto eventDto) {
        return null;
    }

    @Override
    public EventDto getEventById(String id) {
        return null;
    }

    @Override
    public List<EventDto> getAllEvents() {
        return List.of();
    }

    @Override
    public void deleteEventById(String id) {

    }
}
