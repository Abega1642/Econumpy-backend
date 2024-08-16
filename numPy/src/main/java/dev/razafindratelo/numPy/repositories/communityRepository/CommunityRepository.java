package dev.razafindratelo.numPy.repositories.communityRepository;

import dev.razafindratelo.numPy.entity.community.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, String> {
}
