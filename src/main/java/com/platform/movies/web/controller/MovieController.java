package com.platform.movies.web.controller;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.dto.UpdateMovieDto;
import com.platform.movies.domain.exception.MovieDontExistsExeption;
import com.platform.movies.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @Operation(summary = "Save a movie")
    @ApiResponse(responseCode = "201", description = "Movie created")
    @PostMapping
    public ResponseEntity<MovieDto> add(
            @Parameter(description = "Movie save", required = true)
            @RequestBody MovieDto movieDto
    ) {
        return new ResponseEntity<>(movieService.save(movieDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a movie")
    @ApiResponse(responseCode = "200", description = "Movie update")
    @PutMapping("/update/{id}")
    public ResponseEntity<MovieDto> updateMovie(
            @Parameter(description = "Movie updated", required = true)
            @PathVariable long id,
            @RequestBody UpdateMovieDto updateMovieDto
            ){
        return movieService.update(id, updateMovieDto).map(
                ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a movie")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie delete"),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(
            @Parameter(description = "Id the movie for delete", example = "2", required = true)
            @PathVariable long id
    ) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
