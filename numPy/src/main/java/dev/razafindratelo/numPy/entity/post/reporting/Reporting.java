package dev.razafindratelo.numPy.entity.post.reporting;


public class Reporting extends Notification{
    private String body;

    public Reporting(
            String id,
            String title,
            String description,
            Level level,
            String body
    ) {
        super(id, title, description, level);
        this.body = body;
    }
}
