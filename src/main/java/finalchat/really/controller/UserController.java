package finalchat.really.controller;


import finalchat.really.common.ApiResponse;
import finalchat.really.security.UserAuthorize;
import finalchat.really.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@UserAuthorize
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ApiResponse getMemberInfo(@AuthenticationPrincipal User user) {
        log.info("username={}", user.getUsername());

       return ApiResponse.success(userService.getMemberInfo(user.getUsername()));
    }

}
