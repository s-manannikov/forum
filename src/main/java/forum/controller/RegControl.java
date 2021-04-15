package forum.controller;

import forum.model.User;
import forum.service.AuthorityService;
import forum.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegControl {
    private final PasswordEncoder encoder;
    private final UserService users;
    private final AuthorityService authorities;
    private static final String ERROR = "this username is not available! please try again!";

    public RegControl(PasswordEncoder encoder, UserService users, AuthorityService authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        if (users.findUserByUsername(user.getUsername()) == null) {
            users.saveUser(user);
            return "redirect:/login";
        } else {
            model.addAttribute("errorMessage", ERROR);
            return "reg";
        }
    }
}
