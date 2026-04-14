package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreateMisionDto;
import es.fpsumma.academiaespacial.dto.MisionDetalleDto;
import es.fpsumma.academiaespacial.dto.ResponseMisionDto;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Optional;

public interface MisionService {

    public List<ResponseMisionDto> listarMisiones ();

    public Mision mostrarMisionPorId (Integer idMision);

    public void crearMision (CreateMisionDto createMisionDto);

    public void borrarPorId (Integer id);

    public void actualizarEstadoMision (Integer id, EstadoMision estadoMision);

    public List<Mision> filtrarMisionesPorPiloto (Integer idPiloto);

    public Piloto mostrarInformacionDelPilotoAsignado(Integer idMision );

    public MisionDetalleDto mostrarDetalleMision (Integer idMision);



}


