package es.fpsumma.academiaespacial.mapper;

import es.fpsumma.academiaespacial.dto.CreatePilotoDto;
import es.fpsumma.academiaespacial.dto.ResponsePilotoDto;
import es.fpsumma.academiaespacial.model.Piloto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PilotoMapper {

    public Piloto toEntity(CreatePilotoDto createPilotoDto) {
        return new Piloto(
                createPilotoDto.getNombre(),
                createPilotoDto.getRango()
        );
    }

    public ResponsePilotoDto toResponse(Piloto piloto) {

        return new ResponsePilotoDto(
                piloto.getNombre(),
                piloto.getRango()

        );
    }
}
