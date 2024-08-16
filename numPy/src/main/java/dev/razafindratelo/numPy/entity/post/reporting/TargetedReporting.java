package dev.razafindratelo.numPy.entity.post.reporting;

import dev.razafindratelo.numPy.entity.user.User;

public class TargetedReporting extends Reporting{
    private User addressee;

    public TargetedReporting(
            String id,
            String title,
            String description,
            Level level,
            String body,
            User addressee
    ) {
        super(id, title, description, level, body);
        this.addressee = addressee;
    }
}
