package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String nindex() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
