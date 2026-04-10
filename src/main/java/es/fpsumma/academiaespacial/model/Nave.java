package es.fpsumma.academiaespacial.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nave {

    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String modelo;
    private Integer pilotoId;

    public Nave(String nombre, String modelo, Integer pilotoId) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.pilotoId = pilotoId;
    }
}
