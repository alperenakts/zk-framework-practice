package com.alperen.zkmini.service;

import com.alperen.zkmini.UserRole;

import java.util.List;

public interface UserService {

    void addUser(UserRole user);

    void deleteUser(UserRole user);

    boolean exists(UserRole user);

    List<UserRole> getAll();
}
