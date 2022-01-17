package com.codegym.service.impl;

import com.codegym.model.HourShow;
import com.codegym.repository.IHourShowRepository;
import com.codegym.service.IHourShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourShowServiceImpl implements IHourShowService {
    @Autowired
    private IHourShowRepository iHourShowRepository;

    @Override
    public List<HourShow> findAll() {
        return iHourShowRepository.findAll();
    }

    @Override
    public Optional<HourShow> findById(Long id) {
        return iHourShowRepository.findById(id);
    }

    @Override
    public void save(HourShow hourShow) {
        iHourShowRepository.save(hourShow);
    }

    @Override
    public void remove(Long id) {
        iHourShowRepository.deleteById(id);
    }
}
