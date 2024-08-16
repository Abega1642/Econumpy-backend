package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.entity.post.Event;
import dev.razafindratelo.numPy.mapper.userMapper.UserMapper;

public class EventMapper {
    public static EventDto mapToPostDto(Event post) {
        return new EventDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate(),
                UserMapper.MapUserToUserDto(post.getAuthor()),
                post.getStatus()
        );
    }
    public static Event mapToEvent(EventDto eventDto) {
        return new Event(
                eventDto.getPostId(),
                eventDto.getTitle(),
                eventDto.getDescription(),
                eventDto.getLike(),
                eventDto.getDislike(),
                eventDto.getPublishedDate(),
                UserMapper.MapUserToUser(eventDto.getAuthor()),
                eventDto.getStatus()
        );
    }
}
