package dev.razafindratelo.numPy.dtos.postDtos.reportingDtos;


import dev.razafindratelo.numPy.entity.reporting.Level;
import dev.razafindratelo.numPy.entity.reporting.Notification;

public class ReportingDto extends Notification {
    private String body;

    public ReportingDto(
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
