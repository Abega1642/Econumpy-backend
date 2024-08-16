package dev.razafindratelo.numPy.entity.reporting;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("REPORTING")
public class Reporting extends Notification {
    @Column(name = "body", nullable = false)
    private String body;

    public Reporting(
            String id,
            String title,
            String description,
            Level level,
            String body
    ) {
        super(id, title, description, level);
        this.body = body;
    }
}
