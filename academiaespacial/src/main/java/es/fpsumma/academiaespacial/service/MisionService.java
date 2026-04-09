package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.model.Mision;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;

public interface MisionService {

    public List<Mision> listarMisiones ();

    public Mision mostrarMisionPorId (Integer idMision);

    public void crearMision (String codigo, String destino, EstadoMision estadoMision, Integer naveId);

    public void borrarPorId (Integer id);

    public void actualizarEstadoMision (Integer id, EstadoMision estadoMision);

    public List<Mision> filtrarMisionesPorPiloto (Integer idPiloto);

    public Piloto mostrarInformacionDelPilotoAsignado(Integer idMision );



}


