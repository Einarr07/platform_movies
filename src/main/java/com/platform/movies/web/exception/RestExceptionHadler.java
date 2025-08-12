package com.platform.movies.web.exception;

import com.platform.movies.domain.exception.MovieAlreadyExistsException;
import com.platform.movies.domain.exception.MovieDontExistsExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHadler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handlerExeptionTitle(MovieAlreadyExistsException ex) {
        Error error = new Error("movie-already-exists", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MovieDontExistsExeption.class)
    public ResponseEntity<Error> handlerExeptionId(MovieDontExistsExeption ex) {
        Error error = new Error("movie-dont-exists", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
