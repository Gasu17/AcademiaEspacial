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

    public Mision(String codigo, String destino, EstadoMision estadoMision, Integer naveId) {
        this.codigo = codigo;
        this.destino = destino;
        this.estadoMision = estadoMision;
        this.naveId = naveId;
    }
}
