package dev.razafindratelo.numPy.repositories.userRepository;

import dev.razafindratelo.numPy.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
