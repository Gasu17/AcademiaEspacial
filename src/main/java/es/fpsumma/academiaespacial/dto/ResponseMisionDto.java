package es.fpsumma.academiaespacial.dto;

import es.fpsumma.academiaespacial.model.EstadoMision;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseMisionDto {
    private Integer id;
    private String codigo;
    private String destino;
    private EstadoMision estadoMision;
    private Integer naveId;
}
