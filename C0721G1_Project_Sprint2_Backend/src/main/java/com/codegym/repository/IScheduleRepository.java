package com.codegym.repository;

import com.codegym.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepository extends JpaRepository<Schedule, Long> {
}
