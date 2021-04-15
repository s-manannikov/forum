package forum.service;

import forum.model.Authority;
import forum.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    private final AuthorityRepository authorities;

    public AuthorityService(AuthorityRepository authorities) {
        this.authorities = authorities;
    }

    public Authority findByAuthority(String authority) {
        return authorities.findByAuthority(authority);
    }
}
