package me.code.springposts.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String name, password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
