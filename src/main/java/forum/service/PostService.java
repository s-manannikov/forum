package forum.service;

import org.springframework.stereotype.Service;
import forum.model.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger(3);
    
    public PostService() {
        posts.put(1, Post.of(1, "Test Post1", "This is description of test post"));
        posts.put(2, Post.of(2, "Test Post2", "This is description of test post"));
    }
    
    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public void addPost(Post post) {
        post.setId(id.get());
        post.setCreated(LocalDateTime.now());
        posts.put(id.getAndIncrement(), post);
    }
}