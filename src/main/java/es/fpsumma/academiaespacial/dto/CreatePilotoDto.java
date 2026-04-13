package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreatePilotoDto(


        @NotNull
        String nombre,
        @NotNull
        String rango
) {
}
