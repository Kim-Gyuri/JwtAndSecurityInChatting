package finalchat.really.controller;

import finalchat.really.dto.user.UserInfoResponse;
import org.springframework.security.core.userdetails.User;
import finalchat.really.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping("/loginForm")
    public String loginForm(Model model) {
        return "chat/loginForm";
    }
}
