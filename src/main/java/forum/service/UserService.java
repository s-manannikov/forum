package forum.service;

import forum.model.User;
import forum.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public void saveUser(User user) {
        users.save(user);
    }

    public User findUserById(long id) {
        return users.findById(id).orElse(null);
    }

    public User findUserByUsername(String username) {
        return users.findByUsername(username);
    }
}
