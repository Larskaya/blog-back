package com.spring.project.accessToken;

import com.spring.project.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AccessTokenController {

    private final AccessTokenService accessTokenService;

    public AccessTokenController(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    @PostMapping(path = "/sign-in")
    public void signInUser(@RequestBody User user) {
        accessTokenService.loginUser(user);
    }

    @DeleteMapping(path = "/sign-out/{userId}")
    public void signOutUser(@PathVariable("userId") Long userId) {
//        userService.logoutUser(userId);
    }
}
