package forum.repository;

import org.springframework.data.repository.CrudRepository;
import forum.model.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedDesc();
}