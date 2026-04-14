package es.fpsumma.academiaespacial.mapper;

import es.fpsumma.academiaespacial.dto.ResponseMisionDto;
import es.fpsumma.academiaespacial.model.Mision;
import org.springframework.stereotype.Component;

@Component
public class MisionMapper {

    public Mision toEntity(ResponseMisionDto responseMisionDto) {
        return new Mision(
                responseMisionDto.getId(),
                responseMisionDto.getCodigo(),
                responseMisionDto.getDestino(),
                responseMisionDto.getEstadoMision(),
                responseMisionDto.getNaveId()

        );
    }

    public ResponseMisionDto toDto (Mision mision){
        return new ResponseMisionDto(
                mision.getId(),
                mision.getCodigo(),
                mision.getDestino(),
                mision.getEstadoMision(),
                mision.getNaveId()
        ) ;
    }

}
