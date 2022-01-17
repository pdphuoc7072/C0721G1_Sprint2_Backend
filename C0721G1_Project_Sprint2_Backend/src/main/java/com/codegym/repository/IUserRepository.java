package com.codegym.repository;

import com.codegym.dto.BonusPointDto;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery=true,value="select t.point, t.date, m.name\n" +
            "from ticket t join user u on u.`id` = t.id_user\n" +
            "              join schedule s on s.id =  t.id_schedule\n" +
            "              join movie m on m.id = s.id_movie")
    List<BonusPointDto> getAll();



    @Query(nativeQuery=true,value="select t.point, t.date, m.name\n" +
            "from ticket t join user u on u.`id` = t.id_user\n" +
            "              join schedule s on s.id =  t.id_schedule\n" +
            "              join movie m on m.id = s.id_movie\n" +
            "where t.date between :startDate and :endDate\\n")
    List<BonusPointDto> getBonusPointsByTime(@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2);
}
