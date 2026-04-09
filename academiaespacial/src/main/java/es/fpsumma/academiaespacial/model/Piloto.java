package es.fpsumma.academiaespacial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    private Integer id;
    private String nombre;
    private String rango;

    public Piloto(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    public Optional<Piloto> or() {
    }
}