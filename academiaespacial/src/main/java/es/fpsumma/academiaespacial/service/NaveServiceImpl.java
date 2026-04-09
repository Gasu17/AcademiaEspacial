package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.exceptions.NotFoundException;
import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;
import es.fpsumma.academiaespacial.repository.NaveRepository;
import es.fpsumma.academiaespacial.repository.PilotoRepository;
import es.fpsumma.academiaespacial.repository.PilotoRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class NaveServiceImpl implements NaveService {

    private final NaveRepository naveRepository;
    private final PilotoServiceImpl pilotoService;

    @Override
    public List<Nave> listarNaves() {
        return naveRepository.listAll();
    }

    @Override
    public Optional<Nave> encontrarPorId(Integer id) {
        return Optional.of(naveRepository.findById(id));
    }

    @Override
    public void borrarPorId(Integer id) {
        naveRepository.deleteById(id);
    }

    @Override
    public void registrarNave(String nombre, String modelo, Integer pilotoId) {
        if (pilotoId != null) {
            if (pilotoService.encontrarPorId(pilotoId).isEmpty()) {
                throw new NotFoundException("Id del piloto no encontrada");
            }
        }
        Nave nave = new Nave(
                nombre,
                modelo,
                pilotoId
        );

        naveRepository.save(nave);


    }

    @Override
    // Permite ver el nombre de la nave y el piloto que está asignado a ella
    // REVISAR SI PASAR UN MAP O SIMPLEMENTE REVISAR Q NAVE ESTA ASIGANDA A QUE PILOTO
    public Map<String, Optional<Piloto>> verTodosLosPilotoAsignados() {
        Map<String, Optional<Piloto>> navesPilotos = new HashMap<>();

        for (Nave nave : naveRepository.listAll()) {
            navesPilotos.put(nave.getNombre(), pilotoService.encontrarPorId(nave.getPilotoId()));

        }
        return navesPilotos;
    }

    public Piloto verPilotoAsignado(Integer idNave) {
        encontrarPorId(idNave).
                orElseThrow(() -> new NotFoundException("La nave no ha sido encontrada "));
        try {
            return naveRepository.viewAsignedPilot(idNave);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No se ha encontrado el piloto asignado");
        }


    }
}
