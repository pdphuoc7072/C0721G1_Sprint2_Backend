package com.codegym.repository;

import com.codegym.dto.UserStatsDTO;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,value="select ur.code,ur.name as username,\n" +
            "count(tk.id) as totalticket,\n" +
            "(count(tk.id)*st.price) as totalprice,\n" +
            "(count(tk.id)*st.price/1000) as point\n" +
            "from \n" +
            "user ur join ticket tk on ur.id = tk.user_id\n" +
            "join seat st on tk.id=st.ticket_id\n" +
            "group by ur.id\n" +
            "order by totalprice desc\n" +
            "limit 0,99;")
    List<UserStatsDTO> getUserStatsTop();
}
