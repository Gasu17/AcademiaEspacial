package es.fpsumma.academiaespacial.repository;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;

public interface NaveRepository {

    public List<Nave> listAll();

    public Nave findById(Integer id);


    public void deleteById(Integer id);

    public void save(Nave nave );

    public Piloto viewAsignedPilot(Integer idNave);

    public void quitarPiloto (Integer id );


}
