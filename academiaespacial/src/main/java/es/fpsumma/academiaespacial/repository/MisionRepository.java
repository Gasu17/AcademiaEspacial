package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.Mision;

import java.util.List;

public interface MisionRepository {

    public List<Mision> listAll();

    public Mision findById(Integer id);

    public void save(Mision mision);

    public void deleteById(Integer id);

    public void updateById (Mision mision);

    public List<Mision> findByPilot (Integer idPiloto);



}
