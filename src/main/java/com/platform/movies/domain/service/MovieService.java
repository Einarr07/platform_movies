package com.platform.movies.domain.service;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.repository.IMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<MovieDto> findAll(){
        return this.movieRepository.getAllMovies();
    }

    public Optional<MovieDto> findById(long id){
        return movieRepository.getMovieById(id);
    }
}
