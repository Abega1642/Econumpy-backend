package dev.razafindratelo.numPy.dtos.postDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventDto extends PostDto{
    private String status;

    public EventDto(
            String postId,
            String title,
            String description,
            long like,
            long dislike,
            LocalDate publishedDate,
            String authorEmail,
            String status
    ) {
        super(postId, title, description, like, dislike, publishedDate, authorEmail);
        this.status = status;
    }
}
