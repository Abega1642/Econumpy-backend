package dev.razafindratelo.numPy.entity.post.reporting;

import dev.razafindratelo.numPy.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class ZoneReporting extends Reporting{
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
