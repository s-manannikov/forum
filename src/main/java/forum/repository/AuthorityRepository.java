package forum.repository;

import org.springframework.data.repository.CrudRepository;
import forum.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    Authority findByAuthority(String authority);
}