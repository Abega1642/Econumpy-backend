package dev.razafindratelo.numPy.entity.post.reporting;

import dev.razafindratelo.numPy.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class ZoneReporting extends Notification {
    private List<User> users;

    public ZoneReporting(
            String id,
            String title,
            String description,
            Level level
    ) {
        super(id, title, description, level);
        this.users = new ArrayList<>();
    }
}
