package com.codegym.repository;

import com.codegym.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat, Long> {
    @Query(value = "SELECT `name` FROM  c0721g1_project_sprint2_backend.seat WHERE status=1", nativeQuery = true)
    List<String> findSeatByStatus();
}
