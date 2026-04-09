package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;

public interface PilotoRepository {

    public List<Piloto> listAll();

    public Piloto findById(Integer id);


    public void updateById(Piloto piloto);

    public void deleteById(Integer id);

    public void save();

}
