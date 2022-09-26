package com.spring.project.user;

import com.spring.project.accessToken.AccessToken;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_sequence")
    private Long id;

    @OneToOne(mappedBy = "accessToken")
    private AccessToken accessToken;

    private String login;

    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccessToken getToken() {
        return accessToken;
    }

    public void setToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", token=" + accessToken +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
