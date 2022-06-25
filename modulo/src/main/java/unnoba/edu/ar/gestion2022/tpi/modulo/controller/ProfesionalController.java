package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.ProfessionalService;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;

import java.util.List;
@Controller
@SessionAttributes("listado")
public class ProfesionalController {

    @Autowired
    private UserService userService;

    @GetMapping("/listado")
    public String listado() {
        return "listado";
    }

    @GetMapping("/plomeros")
    public String listaPlomero(Model model){
        List<User> plomero = userService.listadoPlomeros();
        model.addAttribute("listado", plomero);
        return "plomeros";
    }

    @GetMapping("/gasistas")
    public String listaGasistas(Model model){
        List<User> gasistas = userService.listadoGasistas();
        model.addAttribute("listado", gasistas);
        return "gasistas";
    }

    @GetMapping("/electricistas")
    public String listaElectricistas(Model model){
        List<User> electricistas = userService.listadoElectricistas();
        model.addAttribute("listado", electricistas);
        return "electricistas";
    }

    @GetMapping("/albaniles")
    public String listaAlbaniles(Model model){
        List<User> albaniles = userService.listadoAlbaniles();
        model.addAttribute("listado", albaniles);
        return "albaniles";
    }
}
