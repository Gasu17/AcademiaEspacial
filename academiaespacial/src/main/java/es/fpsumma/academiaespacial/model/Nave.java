package es.fpsumma.academiaespacial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nave {

    private Integer id;
    private String nombre;
    private String modelo;
    private Integer pilotoId;


}
