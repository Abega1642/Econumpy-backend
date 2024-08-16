package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("INDIVIDUAL")
public class Individual extends User {

    @Column(name ="user_birthdate")
    private LocalDate birthDate;

    public Individual(
            String email,
            String password,
            String address,
            String phoneNumber,
            String username,
            List<Community> communities,
            List<Post> posts,
            long score,
            LocalDate birthDate
    ) {
        super(email, password, address, phoneNumber, username, communities, posts, score);
        this.birthDate = birthDate;
    }
}
