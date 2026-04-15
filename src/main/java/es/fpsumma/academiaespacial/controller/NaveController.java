package es.fpsumma.academiaespacial.controller;

import es.fpsumma.academiaespacial.dto.CreateNaveDto;
import es.fpsumma.academiaespacial.service.NaveServiceImpl;
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
@Data
@AllArgsConstructor
@Controller
@RequestMapping("/naves")
public class NaveController {
    private final PilotoServiceImpl pilotoServiceImpl;
    NaveServiceImpl naveService;

    @GetMapping
    public String verNaves(Model model) {
        model.addAttribute("naves", naveService.listarNaves());
        return "naves";
    }

    @GetMapping("/nueva-nave")
    public String nuevaNave(Model model) {
        model.addAttribute("listaPilotos", pilotoServiceImpl.listarPilotos());
        model.addAttribute("nave", CreateNaveDto.builder().build());
        return "nueva-nave";
    }

    @PostMapping("/guardar")
    public String guardarNave(@Valid @ModelAttribute("nave") CreateNaveDto naveDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.warn("El dto no cumple con las validaciones");
            return ("nueva-nave");
        }
        naveService.registrarNave(naveDto);
        return "redirect:/naves";
    }



}
