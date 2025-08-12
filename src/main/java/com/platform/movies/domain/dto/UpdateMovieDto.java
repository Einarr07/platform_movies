package com.platform.movies.domain.dto;

import com.platform.movies.domain.Genre;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating,
        Boolean state
) {
}
