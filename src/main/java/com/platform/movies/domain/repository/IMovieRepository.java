package com.platform.movies.domain.repository;

import com.platform.movies.domain.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository {

    List<MovieDto> getAllMovies();
    Optional<MovieDto> getMovieById(long id);

}
