package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponsePilotoDto {

    String nombre;
    String rango;
}
