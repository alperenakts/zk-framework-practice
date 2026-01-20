package com.alperen.zkmini.service;

import com.alperen.zkmini.UserRole;

import java.util.ArrayList;
import java.util.List;
import com.alperen.zkmini.repository.UserRepository;
import com.alperen.zkmini.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<UserRole> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(UserRole user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(UserRole user) {
        userRepository.delete(user);
    }

    @Override
    public boolean exists(UserRole user) {
        return userRepository.exists(user);
    }
}
