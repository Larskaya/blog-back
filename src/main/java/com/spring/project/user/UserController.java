package com.spring.project.user;

import com.spring.project.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> get() {
        return userService.getUser();
    }

    @PostMapping(path = "/sign-up")
    public void signUpUser(@RequestBody User user) {
        userService.addNewUser(user);
    }



}
