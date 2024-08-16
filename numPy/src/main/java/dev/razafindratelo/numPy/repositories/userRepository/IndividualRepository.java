package dev.razafindratelo.numPy.repositories.userRepository;

import dev.razafindratelo.numPy.entity.user.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, String> {
}
