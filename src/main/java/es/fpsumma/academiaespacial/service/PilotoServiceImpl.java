package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreatePilotoDto;
import es.fpsumma.academiaespacial.exceptions.NotFoundException;
import es.fpsumma.academiaespacial.model.Piloto;
import es.fpsumma.academiaespacial.repository.NaveRepository;
import es.fpsumma.academiaespacial.repository.NaveRepositoryImpl;
import es.fpsumma.academiaespacial.repository.PilotoRepository;
import es.fpsumma.academiaespacial.repository.PilotoRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class PilotoServiceImpl implements PilotoService {

    private final PilotoRepositoryImpl pilotoRepository;
    private final NaveRepositoryImpl naveRepository;

    @Override
    public List<Piloto> listarPilotos() {
        return pilotoRepository.listAll();
    }

    @Override
    public void borrarPiloto(Integer id) {
        naveRepository.quitarPiloto(id);
        pilotoRepository.deleteById(id);
    }

    @Override
    public void crearPiloto(CreatePilotoDto createPilotoDto) {
        Piloto piloto = new Piloto(
                createPilotoDto.nombre(),
                createPilotoDto.rango()
        );
        pilotoRepository.save(piloto);
    }

    public Piloto encontrarPorId(Integer id) {
        try {
            return pilotoRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No fue encontrado el piloto ");
        }


    }
}
