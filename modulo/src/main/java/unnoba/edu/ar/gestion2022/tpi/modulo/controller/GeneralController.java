package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping({"/index", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", "Página principal");
        return "index";
    }

}
