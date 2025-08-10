package com.platform.movies.domain.repository;

import com.platform.movies.domain.dto.MovieDto;

import java.util.List;

public interface IMovieRepository {

    List<MovieDto> getAllMovies();
}
