package com.codegym.repository;

import com.codegym.model.DayShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDayShowRepository extends JpaRepository<DayShow, Long> {
}
