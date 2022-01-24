package com.codegym.service;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User>{

    Optional<User> findByCode(String code);
    Page<User> findAllUser(String code, String name, String phone, Pageable pageable);
    boolean existsByIdUser(Long id);
    List<User> getAll();
}
