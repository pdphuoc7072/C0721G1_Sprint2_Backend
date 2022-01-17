package com.codegym.repository;

import com.codegym.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatRepository extends JpaRepository<Seat, Long> {
}
