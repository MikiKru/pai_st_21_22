package pl.edu.pbs.pai_lect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pbs.pai_lect.model.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
