package com.alperen.zkmini.repository;

import com.alperen.zkmini.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final List<UserRole> users = new ArrayList<>();

    @Override
    public List<UserRole> findAll() {
        return users;
    }

    @Override
    public void save(UserRole user) {
        users.add(user);
    }

    @Override
    public void delete(UserRole user) {
        users.remove(user);
    }

    @Override
    public boolean exists(UserRole user) {
        return users.contains(user);
    }
}
