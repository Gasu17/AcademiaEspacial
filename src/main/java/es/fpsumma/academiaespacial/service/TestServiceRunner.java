package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.service.MisionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestServiceRunner implements CommandLineRunner {

    private final MisionService misionService;

    public TestServiceRunner(MisionService misionService) {
        this.misionService = misionService;
    }

    @Override
    public void run(String... args) {
     //   System.out.println(misionService.listarMisiones());
        System.out.println(misionService.mostrarInformacionDelPilotoAsignado(2));
    }
}