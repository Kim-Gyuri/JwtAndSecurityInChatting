package finalchat.really.repo;


import finalchat.really.entity.User;
import finalchat.really.entity.UserLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findAllByUserLevel(UserLevel type);

}
