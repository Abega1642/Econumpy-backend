package dev.razafindratelo.numPy.dtos.postDtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class PostDto {
    private String postId;
    private String title;
    private String description;
    private long like;
    private long dislike;
    private LocalDate publishedDate;
}

