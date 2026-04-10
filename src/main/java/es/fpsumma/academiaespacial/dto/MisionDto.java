package es.fpsumma.academiaespacial.dto;

import es.fpsumma.academiaespacial.model.EstadoMision;
import jakarta.validation.constraints.NotNull;

public record MisionDto(
        @NotNull
        String codigo,
        @NotNull
        String destino,
        @NotNull
        EstadoMision estadoMision,
        @NotNull
        Integer naveId
) {


}
