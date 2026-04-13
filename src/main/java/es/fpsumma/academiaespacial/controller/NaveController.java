package es.fpsumma.academiaespacial.controller;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.service.NaveServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Data
@AllArgsConstructor
@Controller
public class NaveController {
    NaveServiceImpl naveService;
    //Paginas

    // Mostrar las un listado de las naves
//    1. **Mostrar el listado completo de pilotos registrados en el sistema.**
//            2. **Mostrar el listado completo de naves registradas en el sistema.**  --
//            3. **Mostrar qué piloto tiene asignada cada nave.**
//            4. **Mostrar el listado completo de misiones registradas en el sistema.**
//            5. **Mostrar, para cada misión del listado, su código, destino, estado y el nombre de la nave asignada.**
//            6. **Mostrar el detalle de una misión concreta a partir de su identificador.**
//            7. **Mostrar, dentro del detalle de una misión, la información de la nave asociada.**
//            8. **Mostrar, dentro del detalle de una misión, la información del piloto responsable.**
//            9. **Registrar una nueva misión indicando sus datos principales y la nave a la que queda asociada.**
//            10. **Modificar el estado de una misión existente.**
//            11. **Eliminar una misión existente.**
    @GetMapping("/naves")
    public String verNaves(Model model) {
        model.addAttribute("naves", naveService.listarNaves());
        return "naves";
    }

    @GetMapping("/nueva-nave")
    public String nuevaNave(Model model) {
        model.addAttribute("nave", CreateNaveDto.builder().build());
        return "nueva-nave";
    }

    @PostMapping("/guardar")
    public String guardarNave(@Valid @ModelAttribute("nave") CreateNaveDto naveDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("El dto no cumple con las validaciones");
            return ("/nuevaNave");
        }
        naveService.registrarNave(naveDto);
        return "/naves";
    }



}
