package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;

public record NaveDto(
        @NotNull
        String nombre,
        @NotNull
        String modelo,

        Integer pilotoId
) {
}
