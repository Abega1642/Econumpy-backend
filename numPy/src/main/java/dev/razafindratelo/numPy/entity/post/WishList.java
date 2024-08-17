package dev.razafindratelo.numPy.entity.post;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("WISHLIST")
public class WishList extends Post{

    @Column(name = "number_of_vote")
    private long numberOfVote;

    public WishList(String postId,
                    String title,
                    String description,
                    long like,
                    long dislike,
                    LocalDate publishedDate,
                    User author
    ) {
        super(postId, title, description, like, dislike, publishedDate, author);
        this.numberOfVote = 0;
    }
}
