package com.platform.movies.domain.repository;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.dto.UpdateMovieDto;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository {

    List<MovieDto> getAllMovies();

    Optional<MovieDto> getMovieById(long id);

    MovieDto save(MovieDto movieDto);

    Optional<MovieDto> update(long id, UpdateMovieDto updateMovieDto);

    void deleteMovieById(long id);
}
