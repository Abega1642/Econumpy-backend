package dev.razafindratelo.numPy.entity.post;

import java.time.LocalDate;

public abstract class Post {
    private String postId;
    private String title;
    private String description;
    private long like;
    private long dislike;
    private LocalDate publishedDate;
}
