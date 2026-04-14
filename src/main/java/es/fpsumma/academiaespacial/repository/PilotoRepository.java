package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Optional;

public interface PilotoRepository {

    public List<Piloto> listAll();

    public Piloto findById(Integer id);


    public void deleteById(Integer id);

    public void save(Piloto piloto);
    public List<Nave> verPilotoAsignado (Integer idPiloto) ;

}
