package com.platform.movies.web.controller;

import com.platform.movies.domain.dto.MovieDto;
import com.platform.movies.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
@Tag(name = "movies", description = "Operations relashionship with movies")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "Get all movies")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/")
    public List<MovieDto> getAllMovies(){
        return movieService.findAll();
    }
}
