package dev.razafindratelo.numPy.entity.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
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
