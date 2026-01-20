package com.alperen.zkmini.repository;

import com.alperen.zkmini.UserRole;

import java.util.List;

public interface UserRepository {

    List<UserRole> findAll();

    void save(UserRole user);

    void delete(UserRole user);

    boolean exists(UserRole user);
}
