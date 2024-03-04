package finalchat.really.entity;

import finalchat.really.dto.user.signup.req.SignupRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="user_id")
    private Long id;

   // private String secret; // uuid 로  user 조회

    private String email;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    private User(String email, String password, String name, UserLevel userLevel) {

        this.email = email;
        this.password = password;
        this.name = name;
        this.userLevel = userLevel;
    }


    public static User from(SignupRequest request, PasswordEncoder encoder) {
        return User.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .name(request.getName())
                .userLevel(UserLevel.USER)
                .build();
    }
}
