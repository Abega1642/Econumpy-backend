package dev.razafindratelo.numPy.repositories.userRepository;

import dev.razafindratelo.numPy.entity.user.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
