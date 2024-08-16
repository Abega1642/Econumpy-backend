package dev.razafindratelo.numPy.dtos.reportingDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.reporting.Level;
import dev.razafindratelo.numPy.entity.reporting.Reporting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetedReportingDto extends Reporting {
    private UserDto addressee;

    public TargetedReportingDto(
            String id,
            String title,
            String description,
            Level level,
            UserDto addressee,
            String body
    ) {
        super(id, title, description, level, body);
        this.addressee = addressee;
    }
}
