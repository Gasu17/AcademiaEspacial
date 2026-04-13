package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreatePilotoDto;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PilotoService {

    public List<Piloto> listarPilotos();

    public void borrarPiloto(Integer id);

    public void crearPiloto(CreatePilotoDto createPilotoDto);

    public Piloto encontrarPorId(Integer id);

}
