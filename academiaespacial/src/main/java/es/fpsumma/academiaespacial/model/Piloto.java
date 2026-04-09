package es.fpsumma.academiaespacial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    private Integer id;
    private String nombre;
    private String rango;
}
