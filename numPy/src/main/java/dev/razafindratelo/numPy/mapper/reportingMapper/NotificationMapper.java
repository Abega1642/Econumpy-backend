package dev.razafindratelo.numPy.mapper.reportingMapper;

import dev.razafindratelo.numPy.dtos.reportingDtos.NotificationDto;
import dev.razafindratelo.numPy.entity.reporting.Notification;

public class NotificationMapper {
    public static Notification toNotification(NotificationDto notificationDto) {
        return new Notification(
                notificationDto.getId(),
                notificationDto.getTitle(),
                notificationDto.getDescription(),
                notificationDto.getLevel()
        );
    }

    public static NotificationDto toNotification(Notification notification) {
        return new NotificationDto(
                notification.getId(),
                notification.getTitle(),
                notification.getDescription(),
                notification.getLevel()
        );
    }
}
