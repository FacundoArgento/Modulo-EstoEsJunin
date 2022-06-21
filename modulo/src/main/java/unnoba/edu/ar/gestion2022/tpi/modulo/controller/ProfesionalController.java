package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.ProfesionalServiceImp;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalController {
    
    private ProfesionalServiceImp profesionalService;
    
    public ProfesionalController(ProfesionalServiceImp profesionalService) {
        this.profesionalService = profesionalService;
    }
    
    @GetMapping("/{id}")
    public String getInformacionProfesional(@PathVariable int id, Model model) {
        Profesional profesional = profesionalService.findProfesionalById(id);
        model.addAttribute("profesional", profesional);
        return "profesional/pagina";
    }

    @GetMapping("/")
    public String profesionalIndex(){
        return "profesionales/index";
    }
}
