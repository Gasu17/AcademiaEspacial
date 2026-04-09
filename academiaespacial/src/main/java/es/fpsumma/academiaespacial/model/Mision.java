package es.fpsumma.academiaespacial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mision {
    private Integer id;
    private String codigo;
    private String destino;
    private EstadoMision  estadoMision;
    private Integer naveId;

}
