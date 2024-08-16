package dev.razafindratelo.numPy.entity.post;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class WishList extends Post{
    private List<User> voters;

    public WishList(String postId,
                    String title,
                    String description,
                    long like,
                    long dislike,
                    LocalDate publishedDate,
                    List<User> voters
    ) {
        super(postId, title, description, like, dislike, publishedDate);
        this.voters = voters;
    }
}
