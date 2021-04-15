package forum.controller;

import forum.model.Post;
import forum.model.Reply;
import forum.model.User;
import forum.service.PostService;
import forum.service.ReplyService;
import forum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PostControl {
    private final PostService posts;
    private final ReplyService replies;
    private final UserService users;

    public PostControl(PostService posts, ReplyService replies, UserService users) {
        this.posts = posts;
        this.replies = replies;
        this.users = users;
    }

    @GetMapping("/post")
    public String index(@RequestParam(value = "id") int id, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("post", posts.findPostById(id));
        return "post";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findUserByUsername(name);
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/addpost")
    public String addPost(Post post, @RequestParam("userid") String userid, Model model) {
        User user = users.findUserById(Long.parseLong(userid));
        post.setUser(user);
        posts.addPost(post);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping("/reply")
    public String addReply(@RequestParam Map<String, String> parameters, Model model) {
        Post post = posts.findPostById(Long.parseLong(parameters.get("id")));
        Reply reply = new Reply();
        reply.setDescription(parameters.get("reply"));
        User user = users.findUserById(Long.parseLong(parameters.get("userid")));
        reply.setUser(user);
        post.addReply(reply);
        replies.saveReply(reply);
        posts.addPost(post);
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        return "post";
    }
}
