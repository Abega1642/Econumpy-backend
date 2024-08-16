package dev.razafindratelo.numPy.dtos.postDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;

import java.time.LocalDate;
import java.util.List;

public class WishListDto extends PostDto{
    private List<UserDto> voters;

    public WishListDto(
            String postId,
            String title,
            String description,
            long like,
            long dislike,
            LocalDate publishedDate,
            String authorEmail,
            List<UserDto> voters
    ) {
        super(postId, title, description, like, dislike, publishedDate, authorEmail);
        this.voters = voters;
    }
}
