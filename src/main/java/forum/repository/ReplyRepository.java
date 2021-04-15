package forum.repository;

import forum.model.Reply;
import org.springframework.data.repository.CrudRepository;

public interface ReplyRepository extends CrudRepository<Reply, Long> {
}
