package com.codegym.repository;

import com.codegym.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);
}
