package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NaveService {

    public List<Nave> listarNaves();

    public Optional<Nave> encontrarPorId(Integer id);

    public void borrarPorId(Integer id);

    public void registrarNave(String nombre, String modelo, Integer pilotoId);

    public Map<String, Optional <Piloto> > verTodosLosPilotoAsignados();

}
