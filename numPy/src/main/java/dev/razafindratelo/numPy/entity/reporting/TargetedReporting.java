package dev.razafindratelo.numPy.entity.reporting;

import dev.razafindratelo.numPy.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("TARGETED")
public class TargetedReporting extends Reporting {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User addressee;

    public TargetedReporting(
            String id,
            String title,
            String description,
            Level level,
            String body,
            User addressee
    ) {
        super(id, title, description, level, body);
        this.addressee = addressee;
    }
}
