package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePilotoDto {


    @NotNull
    @Size(max = 40, message = "El nombre no puede tener mas de 40 caracteres")
    String nombre;
    @NotNull
    @Size(max = 25, message = "el rango no puede tener mas de 25 caracteres")
    String rango;

}
