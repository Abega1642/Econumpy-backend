package dev.razafindratelo.numPy.entity.user;

import dev.razafindratelo.numPy.entity.community.Community;
import dev.razafindratelo.numPy.entity.post.Post;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Organization extends User {
    private String NIF;
    private String STAT;
    private String accreditation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Organization that = (Organization) o;
        return Objects.equals(NIF, that.NIF)
                && Objects.equals(STAT, that.STAT)
                && Objects.equals(accreditation, that.accreditation)
                && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), NIF, STAT, accreditation, creationDate);
    }
}
