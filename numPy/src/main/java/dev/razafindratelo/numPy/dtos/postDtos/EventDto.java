package dev.razafindratelo.numPy.dtos.postDtos;

import dev.razafindratelo.numPy.entity.post.Status;

import java.time.LocalDate;

public class EventDto extends PostDto{
    private Status status;

    public EventDto(String postId, String title, String description, long like, long dislike, LocalDate publishedDate) {
        super(postId, title, description, like, dislike, publishedDate);
    }
}
