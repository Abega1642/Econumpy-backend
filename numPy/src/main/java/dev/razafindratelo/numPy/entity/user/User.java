package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
