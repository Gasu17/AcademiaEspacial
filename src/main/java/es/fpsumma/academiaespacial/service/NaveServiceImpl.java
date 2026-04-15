package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.dto.ResponseNaveDto;
import es.fpsumma.academiaespacial.exceptions.NotFoundException;
import es.fpsumma.academiaespacial.mapper.MisionMapper;
import es.fpsumma.academiaespacial.mapper.NaveMapper;
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
    private final NaveMapper naveMapper;

    @Override
    public List<Nave> listarNaves() {
        return naveRepository.listAll();
    }

    @Override
    public ResponseNaveDto encontrarPorId(Integer id) {
        try {
            return naveMapper.toResponseDto(naveRepository.findById(id));

        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Nave no encontrada");
        }
    }

    @Override
    public void borrarPorId(Integer id) {

        naveRepository.deleteById(id);
    }

    @Override
    public void registrarNave(CreateNaveDto createNaveDto) {
        if (createNaveDto.getPilotoId() != null) {
            pilotoService.encontrarPorId(createNaveDto.getPilotoId());
        }


        naveRepository.save(naveMapper.toEntity(createNaveDto));


    }
    // OBSOLETO
    // @Override
    // Devuelve Nombre de nave y ID del piloto asignado
    // Debes realizar una funcion que devuelva solo las naves con ID de piloto
//    public Map<String, Piloto> verTodosLosPilotoAsignados() {
//        Map<String, Piloto> navesPilotos = new HashMap<>();
//
//        for (Nave nave : naveRepository.listAll()) {
//            navesPilotos.put(nave.getNombre(), pilotoService.encontrarPorId(nave.getPilotoId()));
//
//        }
//        return navesPilotos;
//    }

    public Piloto verPilotoAsignado(Integer idNave) {
        //Valida si existe nave
        encontrarPorId(idNave);

        try {
            return naveRepository.viewAsignedPilot(idNave);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("No se ha encontrado el piloto asignado");
        }


    }


}
