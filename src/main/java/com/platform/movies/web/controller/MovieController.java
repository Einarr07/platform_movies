package com.platform.movies.web.controller;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
@Tag(name = "movies", description = "Operations relashionship with movies")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "Get all movies")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @Operation(summary = "Get one movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Movie not exist")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(
            @Parameter(description = "Id from movie", example = "3", required = true)
            @PathVariable long id
    ) {
        return movieService.findById(id).map(movieDto -> new ResponseEntity<>(movieDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
