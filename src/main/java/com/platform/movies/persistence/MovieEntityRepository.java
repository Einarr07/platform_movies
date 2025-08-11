package com.platform.movies.persistence;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.repository.IMovieRepository;
import com.platform.movies.persistence.entity.MovieEntity;
import com.platform.movies.persistence.mapper.IMovieMapper;
import com.platform.movies.persistence.crud.ICrudMovieEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MovieEntityRepository implements IMovieRepository {

    private final ICrudMovieEntity crudMovieEntity;
    private final IMovieMapper movieMapper;

    @Override
    public List<MovieDto> getAllMovies() {
        return movieMapper.toDto(crudMovieEntity.findAll());
    }

    @Override
    public Optional<MovieDto> getMovieById(long id) {
        return crudMovieEntity.findById(id).map(movieMapper::toDto);
    }
}
