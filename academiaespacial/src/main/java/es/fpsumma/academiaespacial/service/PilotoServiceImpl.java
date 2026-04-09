package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.model.Piloto;
import es.fpsumma.academiaespacial.repository.PilotoRepository;
import es.fpsumma.academiaespacial.repository.PilotoRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class PilotoServiceImpl implements PilotoService {

    private final PilotoRepositoryImpl pilotoRepository;

    @Override
    public List<Piloto> listarPilotos() {
        return pilotoRepository.listAll();
    }

    @Override
    public void borrarPiloto(Integer id) {
        pilotoRepository.deleteById(id);
    }

    @Override
    public void crearPiloto(String nombre, String rango) {
        Piloto piloto = new Piloto(nombre, rango);
        pilotoRepository.save(piloto);
    }
    public Optional <Piloto> encontrarPorId (Integer id) {
        return pilotoRepository.findById(id).or()

    }
}
