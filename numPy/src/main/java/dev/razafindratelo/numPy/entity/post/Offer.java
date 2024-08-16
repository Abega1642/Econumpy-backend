package dev.razafindratelo.numPy.entity.post;

import java.time.LocalDate;

public class Offer extends Post {
    private Status status;

    public Offer(String postId,
                 String title,
                 String description,
                 long like,
                 long dislike,
                 LocalDate publishedDate,
                 Status status
    ) {
        super(postId, title, description, like, dislike, publishedDate);
        this.status = status;
    }
}
