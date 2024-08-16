package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Individual extends User {
    private LocalDate birthDate;

    public Individual(
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
