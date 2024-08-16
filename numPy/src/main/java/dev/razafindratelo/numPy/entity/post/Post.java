package dev.razafindratelo.numPy.entity.post;

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

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private long like;

    @Column
    private long dislike;

    @Column
    private LocalDate publishedDate;
}
