package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.dto.ResponseNaveDto;
import es.fpsumma.academiaespacial.model.Nave;
import es.fpsumma.academiaespacial.model.Piloto;

import java.util.List;
import java.util.Map;

public interface NaveService {

    public List<Nave> listarNaves();

    public ResponseNaveDto encontrarPorId(Integer id);

    public void borrarPorId(Integer id);

    public void registrarNave(CreateNaveDto naveDto);

    // Metodo sin uso
   //  public Map<String, Piloto > verTodosLosPilotoAsignados();

}
