package com.codegym.repository;

import com.codegym.dto.MovieStatsDTO;
import com.codegym.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    @Query(nativeQuery = true,value="select mv.`name`, count(tk.id) as numberticket,(count(tk.id)*st.price) as total\n" +
            "from movie mv join `schedule` chd on mv.id = chd.movie_id\n" +
            "join ticket tk on chd.id = tk.schedule_id\n" +
            "join seat st on tk.id =st.ticket_id\n" +
            "group by mv.id\n" +
            "order by total desc\n" +
            "limit 0,99;")
    List<MovieStatsDTO> getMovieStatsTop();
}
