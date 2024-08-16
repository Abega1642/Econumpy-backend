package dev.razafindratelo.numPy.entity.community;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community")
public class Community {
    @Id
    @Column(name = "community_name")
    private String name;

    @Column(name = "community_description")
    private String description;

    @Column(name = "community_domain")
    private Domain domain;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToMany(mappedBy = "communities")
    private List<User> members;
}
