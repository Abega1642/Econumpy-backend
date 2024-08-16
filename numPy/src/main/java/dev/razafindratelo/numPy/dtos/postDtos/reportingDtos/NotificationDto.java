package dev.razafindratelo.numPy.dtos.postDtos.reportingDtos;

import dev.razafindratelo.numPy.entity.reporting.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private String id;
    private String title;
    private String description;
    private Level level;
}
