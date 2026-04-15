package es.fpsumma.academiaespacial.mapper;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.dto.ResponseNaveDto;
import es.fpsumma.academiaespacial.model.Nave;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
public class NaveMapper {

    public Nave toEntity(CreateNaveDto createNaveDto) {
        return new Nave(
                createNaveDto.getNombre(),
                createNaveDto.getModelo(),
                createNaveDto.getPilotoId()
        );
    }


    public ResponseNaveDto toResponseDto(Nave nave) {

        return new ResponseNaveDto(
                nave.getId(),
                nave.getNombre(),
                nave.getModelo(),
                nave.getPilotoId()
        );
    }


}
