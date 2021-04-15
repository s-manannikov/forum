package forum.service;

import forum.repository.PostRepository;
import org.springframework.stereotype.Service;
import forum.model.Post;

import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        return posts.findAllByOrderByCreatedDesc();
    }

    public Post findPostById(long id) {
        return posts.findById(id).orElse(null);
    }

    public void addPost(Post post) {
        posts.save(post);
    }
}