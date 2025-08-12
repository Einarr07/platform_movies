package com.platform.movies.domain.exception;

public class MovieDontExistsExeption extends RuntimeException {

    public MovieDontExistsExeption(Long id) {
        super("La película con el ID: " + id + " no existe");
    }
}
