package com.spring.project.accessToken;

import com.spring.project.user.User;
import com.spring.project.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccessTokenService {

    private final UserRepository userRepository;
    private final AccessTokenRepository accessTokenRepository;

    public AccessTokenService(UserRepository userRepository, AccessTokenRepository accessTokenRepository) {
        this.userRepository = userRepository;
        this.accessTokenRepository = accessTokenRepository;
    }

    public void loginUser(User user) {
        Optional<AccessToken> token = userRepository.loginUser(user);
        if (token.isPresent()) {
            accessTokenRepository.create(user.getId());
        } else {
            throw new IllegalStateException("forbidden");
        }
    }
}
