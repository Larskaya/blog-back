package com.spring.project.user;

import com.spring.project.accessToken.AccessToken;
import com.spring.project.accessToken.AccessTokenRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccessTokenRepository accessTokenRepository;

    public UserService(UserRepository userRepository,
                       AccessTokenRepository accessTokenRepository) {
        this.userRepository = userRepository;
        this.accessTokenRepository = accessTokenRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByLogin = userRepository.findUserByLogin(user.getLogin());
        if (userByLogin.isPresent()) {
            throw new IllegalStateException("login taken");
        }
        userRepository.save(user);
    }

    public void loginUser(User user, AccessToken accessToken) {
        Optional<User> userByLogin = userRepository.findUserByLogin(user.getLogin());
        if (userByLogin.isEmpty()) {
            throw new IllegalStateException("user not found");
        }
        // generate token(set) -> get token (get) -> add to table 'tokens' ?
        accessTokenRepository.save(accessToken);
    }

    public void logoutUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }
}
