package forum.controller;

import forum.model.Post;
import forum.model.Reply;
import forum.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/post")
    public String index(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", posts.findPostById(id));
        return "post";
    }

    @GetMapping("/add")
    public String addPost() {
        return "add";
    }

    @PostMapping("/addpost")
    public String addPost(@RequestParam("description") String desc, @RequestParam("name") String name, Model model) {
        Post post = new Post();
        //String[] lines = desc.split(System.getProperty("line.separator"));
        post.setName(name);
        post.setDesc(desc);
        posts.addPost(post);
        return "redirect:/";
    }

    @PostMapping("/reply")
    public String addReply(@RequestParam(value = "id") int id, @RequestParam("reply") String text, Model model) {
        Post post = posts.findPostById(id);
        Reply reply = new Reply();
        reply.setDesc(text);
        post.addReply(reply);
        model.addAttribute("post", post);
        return "post";
    }
}
