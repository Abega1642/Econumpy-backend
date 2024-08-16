package dev.razafindratelo.numPy.dtos.postDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private String postId;
    private String title;
    private String description;
    private long like;
    private long dislike;
    private LocalDate publishedDate;
}

