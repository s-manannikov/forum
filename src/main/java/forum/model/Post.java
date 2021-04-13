package forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {
    private int id;
    private String name;
    private String desc;
    private LocalDateTime created;
    private List<Reply> replies = new ArrayList<>();

    public static Post of(int id, String name, String desc) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.desc = desc;
        post.created = LocalDateTime.now();
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void addReply(Reply reply) {
        this.replies.add(reply);
    }

    public List<Reply> getReplies() {
        return replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(name, post.name) &&
                Objects.equals(desc, post.desc) &&
                Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}