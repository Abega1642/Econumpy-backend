package dev.razafindratelo.numPy.entity.post;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    CANCELED("CANCELED"),
    WAITING("WAITING"),
    FORBIDDEN("FORBIDDEN"),
    CONFIRMED("CONFIRMED");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}
