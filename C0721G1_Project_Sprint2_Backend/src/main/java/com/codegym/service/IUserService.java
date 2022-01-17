package com.codegym.service;

import com.codegym.model.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
     Optional<User> findByUsername(String username);
    Optional<User> findByEmailContaining(String email);
    void save(User user);
}
