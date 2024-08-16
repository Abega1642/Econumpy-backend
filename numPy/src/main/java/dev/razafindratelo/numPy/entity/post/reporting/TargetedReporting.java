package dev.razafindratelo.numPy.entity.post.reporting;

import dev.razafindratelo.numPy.entity.user.User;

public class TargetedReporting extends Notification{
    private User addressee;

    public TargetedReporting(
            String id,
            String title,
            String description,
            Level level,
            User addressee
    ) {
        super(id, title, description, level);
        this.addressee = addressee;
    }
}
