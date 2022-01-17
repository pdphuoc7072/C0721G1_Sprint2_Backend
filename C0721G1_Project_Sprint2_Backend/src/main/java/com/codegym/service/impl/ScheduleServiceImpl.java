package com.codegym.service.impl;

import com.codegym.model.Schedule;
import com.codegym.repository.IScheduleRepository;
import com.codegym.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private IScheduleRepository iScheduleRepository;

    @Override
    public List<Schedule> findAll() {
        return iScheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return iScheduleRepository.findById(id);
    }

    @Override
    public void save(Schedule schedule) {
        iScheduleRepository.save(schedule);
    }

    @Override
    public void remove(Long id) {
        iScheduleRepository.deleteById(id);
    }
}
