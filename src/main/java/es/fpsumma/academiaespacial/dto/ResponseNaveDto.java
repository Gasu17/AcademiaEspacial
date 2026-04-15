package es.fpsumma.academiaespacial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ResponseNaveDto {

    Integer id;

    String nombre;

    String modelo;

    Integer pilotoId;

    public ResponseNaveDto(Integer pilotoId, String nombre, String modelo) {
        this.pilotoId = pilotoId;
        this.modelo = modelo;
        this.nombre = nombre;
    }
}
