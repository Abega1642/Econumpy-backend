package dev.razafindratelo.numPy.repositories.postRepository;

import dev.razafindratelo.numPy.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
