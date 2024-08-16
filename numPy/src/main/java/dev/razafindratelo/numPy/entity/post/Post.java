package dev.razafindratelo.numPy.entity.post;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Post {

    @Id
    private String postId;

    @Column(name = "post_title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_like")
    private long numberOfLike;

    @Column(name = "number_of_dislike")
    private long numberOfDislike;

    @Column(name = "publish_date")
    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User author;
}
