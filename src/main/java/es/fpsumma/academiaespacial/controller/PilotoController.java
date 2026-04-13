package es.fpsumma.academiaespacial.controller;

import es.fpsumma.academiaespacial.dto.CreatePilotoDto;
import es.fpsumma.academiaespacial.service.PilotoServiceImpl;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@Data
@AllArgsConstructor
@RequestMapping("/pilotos")
public class PilotoController {
    PilotoServiceImpl pilotoService;


    @GetMapping
    public String verPilotos (Model model){
        model.addAttribute("pilotos", pilotoService.listarPilotos());
        return "pilotos";
    }


    @GetMapping ("/nuevo-piloto")
    public String nuevoPiloto (Model model){
        model.addAttribute("piloto", CreatePilotoDto.builder().build() );
        return "nuevo-piloto";
    }


    @PostMapping ("/guardar-piloto")
    public String guardarPiloto (@Valid @ModelAttribute ("piloto") CreatePilotoDto createPilotoDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            log.info("El dto no cumple las validaciones");
            return "nuevo-piloto";
        }
        pilotoService.crearPiloto(createPilotoDto);
        log.info(" piloto creado");
        return "redirect:/pilotos";
    }


}
