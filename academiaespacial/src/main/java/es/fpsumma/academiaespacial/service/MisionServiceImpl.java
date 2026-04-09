package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.exceptions.NotFoundException;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import es.fpsumma.academiaespacial.model.Piloto;
import es.fpsumma.academiaespacial.repository.MisionRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class MisionServiceImpl implements MisionService {
    private final MisionRepositoryImpl misionRepository;
    private final NaveServiceImpl naveService;

    @Override
    public List<Mision> listarMisiones() {
        return misionRepository.listAll();
    }

    @Override
    public Mision mostrarMisionPorId(Integer idMision) {
        try {
            return misionRepository.findById(idMision);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("La mision no fue encontrada");
        }

    }

    @Override
    public void crearMision(String codigo, String destino, EstadoMision estadoMision, Integer naveId) {
        naveService.encontrarPorId(naveId).
                orElseThrow(() -> new NotFoundException("El id de la nave no fue encontrado"));

        Mision mision = new Mision(
                codigo,
                destino,
                estadoMision,
                naveId
        );

        misionRepository.save(mision);
        log.info("Se guardo la misión");
    }

    @Override
    public void borrarPorId(Integer id) {

        misionRepository.deleteById(id);
        log.info("Elemento borrado");

    }

    @Override
    public void actualizarEstadoMision(Integer id, EstadoMision estadoMision) {
        naveService.encontrarPorId(id).
                orElseThrow(() -> new NotFoundException("La misión no fue encontrada"));

        if (estadoMision == null) {
            throw new IllegalArgumentException("El estado de la misión no puede ser nulo");
        }

        misionRepository.updateStateById(id, estadoMision);
    }

    @Override
    public List<Mision> filtrarMisionesPorPiloto(Integer idPiloto) {

        try {
            return misionRepository.filterMisionByPilotId(idPiloto);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("El piloto no fue encontrado ");
        }

    }
// Permite ver desde la mision el piloto que tiene asignado la nave que esta asociada a la mision
    @Override
    public Piloto mostrarInformacionDelPilotoAsignado(Integer idMision) {
        Mision mision = misionRepository.findById(idMision);
        return naveService.verPilotoAsignado(mision.getNaveId());


    }
}
