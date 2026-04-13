package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Map;

public interface NaveService {

    public List<Nave> listarNaves();

    public Nave encontrarPorId(Integer id);

    public void borrarPorId(Integer id);

    public void registrarNave(CreateNaveDto naveDto);

    public Map<String, Piloto > verTodosLosPilotoAsignados();

}
