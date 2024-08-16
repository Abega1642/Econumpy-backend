package dev.razafindratelo.numPy.dtos.reportingDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.reporting.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneReportingDto extends ReportingDto {
    List<UserDto> users;

    public ZoneReportingDto(
            String id,
            String title,
            String description,
            Level level,
            String body
    ) {
        super(id, title, description, level, body);
        this.users = new ArrayList<>();
    }
}
