package com.platform.movies.persistence.repository;

import com.platform.movies.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrudMovieEntity extends CrudRepository<MovieEntity, Long> {
}
