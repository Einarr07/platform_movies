package com.platform.movies.domain.service;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.repository.IMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<MovieDto> findAll(){
        return this.movieRepository.getAllMovies();
    }
}
