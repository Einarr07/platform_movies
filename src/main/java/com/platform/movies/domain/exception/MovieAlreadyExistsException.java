package com.platform.movies.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {

    public MovieAlreadyExistsException(String movieTitle) {
        super("La peícula " + movieTitle + " ya existe");
    }
}
