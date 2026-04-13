package es.fpsumma.academiaespacial.controller;

import es.fpsumma.academiaespacial.dto.CreateMisionDto;
import es.fpsumma.academiaespacial.model.EstadoMision;
import es.fpsumma.academiaespacial.service.MisionServiceImpl;
import es.fpsumma.academiaespacial.service.NaveServiceImpl;
import es.fpsumma.academiaespacial.service.PilotoServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Data
@AllArgsConstructor
@Slf4j
@RequestMapping("/misiones")
public class MisionesController {
    MisionServiceImpl misionService;
    NaveServiceImpl naveService;
    PilotoServiceImpl pilotoService;




    @GetMapping
    public String verMisiones(Model model) {
        log.info("Intento de ver controlador");
        model.addAttribute("misiones", misionService.listarMisiones());
        return "misiones";
    }


    @GetMapping("/nueva-mision")
    public String nuevaMision(Model model) {
        model.addAttribute("mision", CreateMisionDto.builder().build());
        return "nueva-mision";
    }

    @PostMapping("/guardar-mision")
    public String guardarMision(@Valid @ModelAttribute("mision") CreateMisionDto createMisionDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("El dto no cumple con las validaciones");
            return "nueva-mision";
        }
        return ("redirect:/misiones");


    }

    @GetMapping("/{id}")
    public String detalleMision(@PathVariable Integer id, Model model) {
        model.addAttribute("mision", misionService.mostrarDetalleMision(id));
        return "detalle-mision";
    }

    @GetMapping("/editar/{id}")
    public String verDetalleMision(@PathVariable  Integer id, Model model) {
        model.addAttribute("mison", misionService.mostrarMisionPorId(id));
        return ("detalle-mision");
    }

    @PostMapping("/{id}")
    public String actualizarEstado(@PathVariable Integer id, @RequestParam EstadoMision estado) {
        if (estado == null) {
            log.warn("Estado nulo");
            return "redirect:/misiones";
        }
        misionService.actualizarEstadoMision(id, estado);
        return ("redirect:/misiones/" + id);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMision(@PathVariable Integer id) {
        misionService.borrarPorId(id);

        return "redirect:/misiones";
    }

}
