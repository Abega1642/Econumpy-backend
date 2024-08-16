package dev.razafindratelo.numPy.mapper.postMapper;

import dev.razafindratelo.numPy.dtos.postDtos.EventDto;
import dev.razafindratelo.numPy.dtos.postDtos.PostDto;
import dev.razafindratelo.numPy.entity.post.Event;
import dev.razafindratelo.numPy.entity.post.Post;

public class EventMapper {
    public static EventDto mapToPostDto(Event post) {
        return new EventDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getNumberOfLike(),
                post.getNumberOfDislike(),
                post.getPublishedDate()
        );
    }
}
