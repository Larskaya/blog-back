package com.spring.project.user;

import com.spring.project.token.Token;
import com.spring.project.token.TokenRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public UserService(UserRepository userRepository,
                       TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
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

    public void loginUser(User user, Token token) {
        Optional<User> userByLogin = userRepository.findUserByLogin(user.getLogin());
        if (userByLogin.isEmpty()) {
            throw new IllegalStateException("user not found");
        }
        // generate token(set) -> get token (get) -> add to table 'tokens' ?
        tokenRepository.save(token);
    }

    public void logoutUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }
}
