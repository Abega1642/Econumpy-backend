package dev.razafindratelo.numPy.dtos.postDtos.reportingDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.post.reporting.Level;

import java.util.ArrayList;
import java.util.List;

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
