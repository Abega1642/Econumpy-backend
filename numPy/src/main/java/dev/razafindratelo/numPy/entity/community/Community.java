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
    private String name;

    @Column
    private String description;

    @Column
    private Domain domain;

    @Column
    private LocalDate creationDate;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> members;
}
