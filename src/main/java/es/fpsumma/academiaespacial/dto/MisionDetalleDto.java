package es.fpsumma.academiaespacial.dto;

import es.fpsumma.academiaespacial.model.EstadoMision;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder

public record MisionDetalleDto(

        Integer id,
        String codigo,
        String destino,
        EstadoMision estado,

        Integer naveId,
        String naveNombre,
        String modelo,

        Integer pilotoId,
        String nombre,
        String rango
) {
}
