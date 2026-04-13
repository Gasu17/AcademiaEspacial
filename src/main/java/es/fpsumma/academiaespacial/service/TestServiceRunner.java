package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.service.MisionService;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestServiceRunner implements CommandLineRunner {

    private final MisionService misionService;
    private final NaveServiceImpl naveService;
    private final PilotoService pilotoService;

    public TestServiceRunner(MisionService misionService, NaveServiceImpl naveService, PilotoServiceImpl pilotoServiceImpl, PilotoService pilotoService) {
        this.misionService = misionService;
        this.naveService = naveService;
        this.pilotoService = pilotoService;
    }

    @Override
    public void run(String... args) {
        System.out.println(pilotoService.listarPilotos());
    }
}