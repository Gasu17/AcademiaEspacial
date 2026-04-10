package es.fpsumma.academiaespacial.service;

import es.fpsumma.academiaespacial.service.MisionService;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestServiceRunner implements CommandLineRunner {

    private final MisionService misionService;
    private final NaveServiceImpl naveService ;

    public TestServiceRunner(MisionService misionService, NaveServiceImpl naveService) {
        this.misionService = misionService;
        this.naveService = naveService;
    }

    @Override
    public void run(String... args) {
     //   System.out.println(misionService.listarMisiones());
        System.out.println(naveService.verTodosLosPilotoAsignados());
    }
}