package dev.razafindratelo.numPy.dtos.postDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.post.Status;
import dev.razafindratelo.numPy.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OfferDto extends PostDto {
    private Status status;

    public OfferDto(
            String postId,
            String title,
            String description,
            long like,
            long dislike,
            LocalDate publishedDate,
            String authorEmail,
            Status status
    ) {
        super(postId, title, description, like, dislike, publishedDate, authorEmail);
        this.status = status;
    }
}
