package dev.razafindratelo.numPy.entity.post;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("OFFER")
public class Offer extends Post {

    @Column(nullable = false)
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
