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

    @Column(name = "nif", nullable = false)
    private String NIF;

    @Column(name = "stat", nullable = false)
    private String STAT;

    @Column(name = "accreditation", nullable = false)
    private String accreditation;

    @Column(name = "creation_date",nullable = false)
    private LocalDate creationDate;

    public Organization(
            String email,
            String password,
            String address,
            String phoneNumber,
            String username,
            List<Community> communities,
            List<Post> posts,
            long score,
            String NIF,
            String STAT,
            String accreditation,
            LocalDate creationDate
    ) {
        super(email, password, address, phoneNumber, username, communities, posts, score);
        this.NIF = NIF;
        this.STAT = STAT;
        this.accreditation = accreditation;
        this.creationDate = creationDate;

    }
}
