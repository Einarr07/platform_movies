package com.platform.movies.persistence;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.dto.UpdateMovieDto;
import com.platform.movies.domain.exception.MovieAlreadyExistsException;
import com.platform.movies.domain.exception.MovieDontExistsExeption;
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

        if (crudMovieEntity.findById(id).isEmpty()) {
            throw new MovieDontExistsExeption(id);
        }

        return crudMovieEntity.findById(id).map(movieMapper::toDto);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistsException(movieDto.title());
        }

        MovieEntity movieEntity = movieMapper.toEntity(movieDto);
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public Optional<MovieDto> update(long id, UpdateMovieDto updateMovieDto) {

        if (crudMovieEntity.findById(id).isEmpty()) {
            throw new MovieDontExistsExeption(id);
        }

        return crudMovieEntity.findById(id).map(entityExistente -> {
            movieMapper.updateEntityFromDto(updateMovieDto, entityExistente);
            return movieMapper.toDto(crudMovieEntity.save(entityExistente));
        });
    }

    @Override
    public void deleteMovieById(long id) {

        if (crudMovieEntity.findById(id).isEmpty()) {
            throw new MovieDontExistsExeption(id);
        }

        crudMovieEntity.deleteById(id);
    }
}
