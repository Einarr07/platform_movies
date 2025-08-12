package com.platform.movies.domain.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El título es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "El rating no puede ser menor a 0")
        @Max(value = 5, message = "El rating no puede ser mayor que 5")
        Double rating,

        @NotNull(message = "El estado es obligatorio")
        Boolean state
) {
}
