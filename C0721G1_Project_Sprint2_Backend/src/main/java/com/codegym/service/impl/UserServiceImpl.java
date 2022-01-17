package com.codegym.service.impl;

import com.codegym.dto.BonusPointDto;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void updateUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public List<BonusPointDto> getAll() {
        return iUserRepository.getAll();
    }

    @Override
    public List<BonusPointDto> getBonusPointsByTime(LocalDate startDate, LocalDate endDate) {
        return iUserRepository.getBonusPointsByTime(startDate, endDate);
    }
}
