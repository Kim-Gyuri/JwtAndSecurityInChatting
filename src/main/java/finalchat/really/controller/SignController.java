package finalchat.really.controller;


import finalchat.really.common.ApiResponse;
import finalchat.really.dto.user.signin.req.SigninRequest;
import finalchat.really.dto.user.signup.req.SignupRequest;
import finalchat.really.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignController {
    private final SignService signService;


    @PostMapping("/sign-up")
    public ApiResponse signUp(@RequestBody SignupRequest request) {
        return ApiResponse.success(signService.registMember(request));
    }


    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody SigninRequest request) {
        return ApiResponse.success(signService.signIn(request));
    }
}
