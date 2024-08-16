package dev.razafindratelo.numPy.entity.post.reporting;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("TARGETED")
public class ZoneReporting extends Reporting{
    @ManyToMany
    @JoinTable(
            name = "zone_reporting_users",
            joinColumns = @JoinColumn(name = "zone_reporting_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public ZoneReporting(
            String id,
            String title,
            String description,
            String body,
            Level level
    ) {
        super(id, title, description, level, body);
        this.users = new ArrayList<>();
    }
}
