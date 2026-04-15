package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreateNaveDto {
    Integer id;
    @NotNull
    String nombre;
    @NotNull
    String modelo;

    Integer pilotoId;

}
