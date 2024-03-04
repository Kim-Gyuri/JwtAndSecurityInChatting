package finalchat.really.dto.user.signin.res;

import finalchat.really.entity.UserLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {

        private String name;
        private UserLevel userLevel;
        private String token;


}
