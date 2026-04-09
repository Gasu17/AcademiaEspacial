package es.fpsumma.academiaespacial.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String rango;

    public Piloto(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }


}