package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreateMisionDto;
import es.fpsumma.academiaespacial.dto.MisionDetalleDto;
import es.fpsumma.academiaespacial.dto.ResponseMisionDto;
import es.fpsumma.academiaespacial.exceptions.NotFoundException;
import es.fpsumma.academiaespacial.mapper.MisionMapper;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import es.fpsumma.academiaespacial.model.Piloto;
import es.fpsumma.academiaespacial.repository.MisionRepositoryImpl;
import jakarta.servlet.ServletOutputStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class MisionServiceImpl implements MisionService {
    private final MisionRepositoryImpl misionRepository;
    private final NaveServiceImpl naveService;

    private final MisionMapper misionMapper;


    @Override
    public List<ResponseMisionDto> listarMisiones() {
        return misionRepository.listAll()
                .stream()
                .map(misionMapper::toDto)
                .toList();
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
    public void crearMision(CreateMisionDto createMisionDto) {
        // Valida si nave existe
        try {


            naveService.encontrarPorId(createMisionDto.getNaveId());
        } catch (Exception e) {
            System.out.println("fallo ->  " + createMisionDto.toString());
        }
try {


    System.out.println(createMisionDto.toString());
    misionRepository.save(createMisionDto);
    log.info("Se guardo la misión");
}  catch (Exception e) {
        System.out.println("fallo 2 ->  " + createMisionDto.toString());
    }

    }

    @Override
    public void borrarPorId(Integer id) {

        misionRepository.deleteById(id);
        log.info("Elemento borrado");

    }

    @Override
    public void actualizarEstadoMision(Integer id, EstadoMision estadoMision) {
        //Valida si existe
        mostrarMisionPorId(id);

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

    @Override
    public MisionDetalleDto mostrarDetalleMision(Integer idMision) {

        log.info(idMision.toString());
        try {
            return misionRepository.viewFullDetailsMision(idMision);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("La mision no fue encontrada");
        }


    }
}
