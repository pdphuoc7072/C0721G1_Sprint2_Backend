package com.codegym.service;

import com.codegym.model.Seat;

import java.util.List;

public interface ISeatService extends IGeneralService<Seat> {
    List<String> findSeatByStatus();
}
