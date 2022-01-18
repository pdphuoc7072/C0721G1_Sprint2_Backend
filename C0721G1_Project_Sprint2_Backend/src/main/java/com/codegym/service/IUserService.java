package com.codegym.service;

import com.codegym.model.User;

public interface IUserService extends IGeneralService<User> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    boolean existsById(long id);
}
