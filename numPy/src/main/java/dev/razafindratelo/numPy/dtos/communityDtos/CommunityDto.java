package dev.razafindratelo.numPy.dtos.communityDtos;

import dev.razafindratelo.numPy.entity.community.Domain;
import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private String name;
    private String description;
    private Domain domain;
    private LocalDate creationDate;
    private List<User> members;
}
