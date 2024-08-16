package dev.razafindratelo.numPy.dtos.postDtos.reportingDtos;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.reporting.Level;
import dev.razafindratelo.numPy.entity.reporting.Reporting;


public class TargetedReporting extends Reporting {
    private UserDto addressee;

    public TargetedReporting(
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
