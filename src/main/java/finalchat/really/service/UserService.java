package finalchat.really.service;


import finalchat.really.dto.user.UserInfoResponse;
import finalchat.really.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository memberRepository;
    private final PasswordEncoder encoder;

    @Transactional(readOnly = true)
    public UserInfoResponse getMemberInfo(String idx) {
        long userId = convertToPk(idx);
        return memberRepository.findById(userId)
                .map(UserInfoResponse::from)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }

    private static long convertToPk(String idx) {
        long userId = Long.parseLong(idx);
        return userId;
    }


}
