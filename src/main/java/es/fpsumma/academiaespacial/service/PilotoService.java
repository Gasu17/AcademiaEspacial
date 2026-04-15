package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreatePilotoDto;
import es.fpsumma.academiaespacial.dto.ResponsePilotoDto;
import es.fpsumma.academiaespacial.model.Piloto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Component
public interface PilotoService {

    public List<Piloto> listarPilotos();

    public void borrarPiloto(Integer id);

    public void crearPiloto(CreatePilotoDto createPilotoDto);

    public ResponsePilotoDto encontrarPorId(Integer id);

}
