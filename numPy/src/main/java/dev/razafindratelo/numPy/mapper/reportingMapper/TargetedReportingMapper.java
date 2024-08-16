package dev.razafindratelo.numPy.mapper.reportingMapper;

import dev.razafindratelo.numPy.dtos.reportingDtos.TargetedReportingDto;
import dev.razafindratelo.numPy.entity.reporting.TargetedReporting;
import dev.razafindratelo.numPy.mapper.userMapper.UserMapper;

public class TargetedReportingMapper {
    public static TargetedReportingDto toTargetedReporting(TargetedReportingDto targetedReportingDto) {
        return new TargetedReportingDto(
                targetedReportingDto.getId(),
                targetedReportingDto.getTitle(),
                targetedReportingDto.getDescription(),
                targetedReportingDto.getLevel(),
                targetedReportingDto.getAddressee(),
                targetedReportingDto.getBody()
        );
    }

    public static TargetedReportingDto toTargetedReporting(TargetedReporting targetedReporting) {
        return new TargetedReportingDto(
                targetedReporting.getId(),
                targetedReporting.getTitle(),
                targetedReporting.getDescription(),
                targetedReporting.getLevel(),
                UserMapper.MapUserToUserDto(targetedReporting.getAddressee()),
                targetedReporting.getBody()
        );
    }
}
