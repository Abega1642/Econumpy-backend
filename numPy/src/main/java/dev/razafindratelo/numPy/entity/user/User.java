package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class User {
    @Id
    protected String email;

    @Column
    protected String password;

    @Column
    protected String address;

    @Column
    protected String phoneNumber;

    @Column
    protected String username;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Community> communityList;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Post> posts;

    @Column
    protected long score;

}
