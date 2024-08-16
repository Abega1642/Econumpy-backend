package dev.razafindratelo.numPy.repositories.userRepository;

import dev.razafindratelo.numPy.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
