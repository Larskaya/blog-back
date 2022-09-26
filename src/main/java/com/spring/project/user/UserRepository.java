package com.spring.project.user;

import com.spring.project.accessToken.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
//    void login(User user);

    @Query("select u from User u where u.login = ?1")
    Optional<User> findUserByLogin(String login);

    Optional<AccessToken> loginUser(User user);
}
