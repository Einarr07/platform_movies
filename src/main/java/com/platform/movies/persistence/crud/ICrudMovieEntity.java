package com.platform.movies.persistence.crud;

import com.platform.movies.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudMovieEntity extends CrudRepository<MovieEntity, Long> {

    MovieEntity findFirstByTitulo(String titulo);
}
