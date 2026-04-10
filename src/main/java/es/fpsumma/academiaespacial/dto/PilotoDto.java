package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;

public record PilotoDto(


        @NotNull
        String nombre,
        @NotNull
        String rango
) {
}
