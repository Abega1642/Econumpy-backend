package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("ORGANIZATION")
public class Organization extends User {

    @Column(unique = true, nullable = false)
    private String NIF;

    @Column(unique = true, nullable = false)
    private String STAT;

    @Column(unique = true, nullable = false)
    private String accreditation;

    @Column(nullable = false)
    private LocalDate creationDate;

    public Organization(
            String email,
            String password,
            String address,
            String phoneNumber,
            String username,
            List<Community> communityList,
            List<Post> posts,
            long score
    ) {
        super(email, password, address, phoneNumber, username, communityList, posts, score);
    }
}
