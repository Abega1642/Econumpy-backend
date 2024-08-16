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
import dev.razafindratelo.numPy.services.individualService.IndividualService;
import dev.razafindratelo.numPy.services.individualService.individualImp.IndividualServiceImp;
import dev.razafindratelo.numPy.services.organizationService.OrganizationService;
import dev.razafindratelo.numPy.services.organizationService.oraganizationImpl.OrganizationServiceImpl;
import dev.razafindratelo.numPy.services.postServices.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    PostRepository postRepository;

    @Override
    public EventDto createEvent(EventDto eventDto, String userMail) {
        IndividualService individualService = new IndividualServiceImp();
        Individual individual = IndividualMapper.toIndividual(individualService.getIndividualById(userMail));
        OrganizationService organizationService = new OrganizationServiceImpl();
        Organization organization = OrganizationMapper.toOrganization(organizationService.getOrganizationById(userMail));
        Event createdEvent = new Event();
        if(individual == null) {
            createdEvent = postRepository.save(EventMapper.mapToEvent(eventDto, organization));
        } else if (organization == null) {
            createdEvent = postRepository.save(EventMapper.mapToEvent(eventDto, individual));
        } else {
            throw new ResourceNotFoundException("Event with email " + userMail + " already exists");
        }
        return EventMapper.mapToPostDto(createdEvent);
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
        List<Event> userList = postRepository.findAll()
                .stream()
                .map(post -> (Event) post)
                .toList();

        return userList.stream()
                .map(EventMapper::mapToPostDto)
                .toList();
    }

    @Override
    public void deleteEventById(String id) {
        postRepository.deleteById(id);
    }
}
