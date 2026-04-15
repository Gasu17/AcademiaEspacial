package es.fpsumma.academiaespacial.dto;

import es.fpsumma.academiaespacial.model.EstadoMision;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class CreateMisionDto {
    @NotNull
    @Size(max = 30 , message = "No puede tener mas de 30 caracteres")
    private String codigo;
    @NotNull
    private String destino;
    @NotNull
    private EstadoMision  estadoMision;
    @NotNull
    private Integer naveId;
}

