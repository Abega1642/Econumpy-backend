package dev.razafindratelo.numPy.services.postServices.postServicesImp;

import dev.razafindratelo.numPy.Exceptions.ResourceNotFoundException;
import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.entity.post.Event;
import dev.razafindratelo.numPy.entity.post.Post;
import dev.razafindratelo.numPy.entity.user.Individual;
import dev.razafindratelo.numPy.entity.user.Organization;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.mapper.postMapper.EventMapper;
import dev.razafindratelo.numPy.mapper.statusMapper.StatusMapper;
import dev.razafindratelo.numPy.mapper.userMapper.individualMapper.IndividualMapper;
import dev.razafindratelo.numPy.mapper.userMapper.organizationMapper.OrganizationMapper;
import dev.razafindratelo.numPy.repositories.postRepository.PostRepository;
import dev.razafindratelo.numPy.repositories.userRepository.UserRepository;
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.individualService.individualImp.IndividualServiceImp;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import dev.razafindratelo.numPy.services.organizationService.oraganizationImpl.OrganizationServiceImpl;
import dev.razafindratelo.numPy.services.postServices.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private PostRepository postRepository;

    @Override
    public EventDto createEvent(EventDto eventDto, User user) {
        Event event = postRepository.save(EventMapper.mapToEvent(eventDto, user));
        return EventMapper.mapToPostDto(event);
    }

    @Override
    public EventDto updateEvent(String eventId, EventDto eventDto) {
        Event event = (Event) postRepository.findById(eventId)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + eventId + " wasn't found !")
                );

        event.setStatus(StatusMapper.statusMapper2(eventDto.getStatus()));
        event.setDescription(eventDto.getDescription());
        event.setTitle(eventDto.getTitle());

        Event updatedUser = postRepository.save(event);

        return EventMapper.mapToPostDto(updatedUser);
    }

    @Override
    public EventDto getEventById(String id) {
        Event event = (Event) postRepository.findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("User with id " + id + " wasn't found !")
                );
        return EventMapper.mapToPostDto(event);

    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Post> posts = postRepository.findAll();

        List<Event> eventList = new ArrayList<>();

        for (Post event : posts) {
            if (event instanceof Event) {
                eventList.add((Event) event);
            }
        }
        return eventList.stream()
                .map(EventMapper::mapToPostDto)
                .toList();
    }

    @Override
    public void deleteEventById(String id) {
        postRepository.deleteById(id);
    }
}
