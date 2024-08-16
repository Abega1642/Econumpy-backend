package dev.razafindratelo.numPy.mapper.reportingMapper;

import dev.razafindratelo.numPy.dtos.reportingDtos.ReportingDto;
import dev.razafindratelo.numPy.entity.reporting.Reporting;

public class ReportingMapper {
    public static Reporting toReporting(ReportingDto reportingDto) {
        return new Reporting(
                reportingDto.getId(),
                reportingDto.getTitle(),
                reportingDto.getDescription(),
                reportingDto.getLevel(),
                reportingDto.getBody()
                );
    }

    public static ReportingDto toReporting(Reporting reportingDto) {
        return new ReportingDto(
                reportingDto.getId(),
                reportingDto.getTitle(),
                reportingDto.getDescription(),
                reportingDto.getLevel(),
                reportingDto.getBody()
        );
    }
}
