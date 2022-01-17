package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        iUserRepository.deleteById(id);
    }

//    @Override
//    public Optional<User> findByUserId(Long id) {
//        return iUserRepository.findByUserId(id);
//    }

    @Override
    public Optional<User> findByCode(String code) {
        return iUserRepository.findByCode(code);
    }

    @Override
    public Page<User> findAllUser(String code, String name, String phone, Pageable pageable) {
        return iUserRepository.findAllUser("%" + code + "%", "%" + name + "%", "%" + phone + "%", pageable);
    }

    @Override
    public boolean existsByIdUser(Long id) {
        return iUserRepository.existsById(id);
    }

    @Override
    public List<User> getAll() {
        return iUserRepository.findAll();
    }
}