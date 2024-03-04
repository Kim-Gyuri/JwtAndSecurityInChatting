package finalchat.really.dto.user.signup.res;


import finalchat.really.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SignUpResponse {
   // private UUID id;
    private String email;
    private String name;

    public static SignUpResponse from(User user) {
        return new SignUpResponse(
               // user.getSecret(),
                user.getEmail(),
                user.getName()
        );

    }
}
