package dev.razafindratelo.numPy.entity.post.reporting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Notification{
    private String id;
    private String title;
    private String description;
    private Level level;
}
