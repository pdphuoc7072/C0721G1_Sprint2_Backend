package com.codegym.repository;

import com.codegym.model.HourShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHourShowRepository extends JpaRepository<HourShow, Long> {
}
