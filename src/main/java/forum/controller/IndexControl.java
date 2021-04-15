package forum.controller;

import forum.model.User;
import forum.service.PostService;
import forum.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControl {
    private final PostService posts;
    private final UserService users;

    public IndexControl(PostService posts, UserService users) {
        this.posts = posts;
        this.users = users;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("posts", posts.getAll());
        return "index";
    }
}