package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCode(String code);

    @Query(value = "SELECT * FROM user WHERE `code` LIKE :code AND `name` LIKE :name AND phone LIKE :phone", nativeQuery = true)
    Page<User> findAllUser(@Param("code") String code, @Param("name") String name, @Param("phone") String phone, Pageable pageable);


}
