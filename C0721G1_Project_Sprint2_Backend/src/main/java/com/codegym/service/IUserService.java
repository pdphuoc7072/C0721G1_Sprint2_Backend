package com.codegym.service;

import com.codegym.dto.BonusPointDto;
import com.codegym.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Optional<User> findById(Long id);
    void updateUser(User user);
    List<BonusPointDto> getAll();
    List<BonusPointDto> getBonusPointsByTime(LocalDate startDate, LocalDate endDate);
}
