package dev.razafindratelo.numPy.entity.community;

import dev.razafindratelo.numPy.entity.user.User;

import java.time.LocalDate;
import java.util.List;

public class Community {
    private List<User> members;
    private String name;
    private String description;
    private Domain domain;
    private LocalDate creationDate;
}
