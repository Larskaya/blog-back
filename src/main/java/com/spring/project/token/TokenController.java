package com.spring.project.token;

import com.spring.project.user.User;
import com.spring.project.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TokenController {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public TokenController(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @PostMapping(path = "/sign-in")
    public void signInUser(@RequestBody User user) {
//        userService.loginUser(user);
    }

    @DeleteMapping(path = "/sign-out/{userId}")
    public void signOutUser(@PathVariable("userId") Long userId) {
//        userService.logoutUser(userId);
    }
}
