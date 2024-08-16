package dev.razafindratelo.numPy.dtos.reportingDtos;


import dev.razafindratelo.numPy.entity.reporting.Level;
import dev.razafindratelo.numPy.entity.reporting.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
