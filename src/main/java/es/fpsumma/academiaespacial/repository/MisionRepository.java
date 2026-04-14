package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.dto.CreateMisionDto;
import es.fpsumma.academiaespacial.dto.MisionDetalleDto;
import es.fpsumma.academiaespacial.dto.ResponseMisionDto;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;

import java.util.List;

public interface MisionRepository {

    public List<Mision> listAll();

    public Mision findById(Integer id);

    public void save(CreateMisionDto mision);

    public void deleteById(Integer id);

    public void updateStateById(Integer id, EstadoMision estadoMision);

    public List<Mision> filterMisionByPilotId(Integer idPiloto);

    public MisionDetalleDto viewFullDetailsMision (Integer id);


}
