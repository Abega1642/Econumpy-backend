package dev.razafindratelo.numPy.mapper.statusMapper;

import dev.razafindratelo.numPy.entity.post.Status;

public class StatusMapper {
    public static String statusMapper1(Status status) {
        if (status == Status.FORBIDDEN) {
            return "FORBIDDEN";
        } else if (status == Status.CANCELED) {
            return "CANCELED";
        } else if (status == Status.WAITING) {
            return "WAITING";
        } else {
            return "CONFIRMED";
        }
    }
    public static Status statusMapper2(String status) {
        if (status .equals("FORBIDDEN")) {
            return Status.FORBIDDEN;
        } else if (status.equals( "CANCELED")) {
            return Status.CANCELED;
        } else if (status == "WAITING") {
            return Status.WAITING;
        } else {
            return Status.CONFIRMED;
        }
    }
}
