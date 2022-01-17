package com.codegym.service.impl;

import com.codegym.model.DayShow;
import com.codegym.repository.IDayShowRepository;
import com.codegym.service.IDayShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DayShowServiceImpl implements IDayShowService {
    @Autowired
    private IDayShowRepository iDayShowRepository;
    @Override
    public List<DayShow> findAll() {
        return iDayShowRepository.findAll();
    }
    @Override
    public Optional<DayShow> findById(Long id) {
        return iDayShowRepository.findById(id);
    }
    @Override
    public void save(DayShow dayShow) {
        iDayShowRepository.save(dayShow);
    }
    @Override
    public void remove(Long id) {
        iDayShowRepository.deleteById(id);
    }
}
