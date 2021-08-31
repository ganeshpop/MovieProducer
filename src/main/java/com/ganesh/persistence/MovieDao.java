package com.ganesh.persistence;


import com.ganesh.bean.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
    public interface MovieDao extends JpaRepository<Movie, Integer>{

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET name =:name WHERE id =:id")
    int updateMovieName(@Param("id") int id,@Param("name") String name);

    Movie getMovieByName(String name);
}