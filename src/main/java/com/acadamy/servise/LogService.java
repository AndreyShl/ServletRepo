package com.acadamy.servise;

import com.acadamy.model.User;

import java.util.ArrayList;
import java.util.List;

public class LogService {
    private final List<User> users;

    public LogService() {
        users = new ArrayList<>();
        users.add(new User("Andrei", "123456"));
        users.add(new User("Admin", "PASSWORD"));
    }

    public boolean authenticate(String login, String password){
        if (login.isEmpty() || password.isEmpty()){
        return false;
        }
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }return false;
    }
}
