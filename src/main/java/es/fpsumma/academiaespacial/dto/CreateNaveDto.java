package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateNaveDto(
        Integer id ,
        @NotNull
        String nombre,
        @NotNull
        String modelo,

        Integer pilotoId
) {
}
