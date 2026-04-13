package es.fpsumma.academiaespacial.dto;

import es.fpsumma.academiaespacial.model.EstadoMision;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder

public record CreateMisionDto(
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
