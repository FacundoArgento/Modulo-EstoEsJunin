package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;

import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;


import java.util.List;
@Controller
@SessionAttributes("listado")
public class ProfesionalController {

    @Autowired
    private UserService userService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("titulo", "Listado de profesionales");
        return "listado";
    }

    @RequestMapping(value={"/plomeros", "/plomeros/{param}"}, method=RequestMethod.GET)
    public String listaPlomero(Model model, @Param("param") String palabraClave){
        if(palabraClave!=null){
            List<User> plomero = userService.listadoPlomeros(palabraClave);
            model.addAttribute("listado", plomero);
            model.addAttribute("titulo", "Listado de plomeros");
            return "plomeros";
       }else{
            List<User> plomero = userService.listadoPlomeros();
            model.addAttribute("listado", plomero);
            model.addAttribute("titulo", "Listado de plomeros");
            return "plomeros";
        }
    }

    @RequestMapping(value={"/gasistas", "/gasistas/{param}"}, method=RequestMethod.GET)
    public String listaGasistas(Model model, @Param("param") String palabraClave) {
        if (palabraClave != null) {
            List<User> gasistas = userService.listadoGasistas(palabraClave);
            model.addAttribute("listado", gasistas);
            model.addAttribute("titulo", "Listado de gasistas");
            return "gasistas";
        } else {
            List<User> gasistas = userService.listadoGasistas();
            model.addAttribute("listado", gasistas);
            model.addAttribute("titulo", "Listado de gasistas");
            return "gasistas";
        }
    }

    @RequestMapping(value={"/electricistas", "/electricistas/{param}"}, method=RequestMethod.GET)
    public String listaElectricistas(Model model, @Param("param") String palabraClave) {
        if (palabraClave != null) {
            List<User> electricista = userService.listadoElectricistas(palabraClave);
            model.addAttribute("listado", electricista);
            model.addAttribute("titulo", "Listado de electricistas");
            return "electricistas";
        } else {
            List<User> electricista = userService.listadoElectricistas();
            model.addAttribute("listado", electricista);
            model.addAttribute("titulo", "Listado de electricistas");
            return "electricistas";
        }
    }


    @RequestMapping(value={"/albaniles", "/albaniles/{param}"}, method=RequestMethod.GET)
    public String listaAlbanil(Model model, @Param("param") String palabraClave) {
        if (palabraClave != null) {
            List<User> albanil = userService.listadoAlbaniles(palabraClave);
            model.addAttribute("listado", albanil);
            model.addAttribute("titulo", "Listado de albañiles");
            return "albaniles";
        } else {
            List<User> albanil = userService.listadoAlbaniles();
            model.addAttribute("listado", albanil);
            model.addAttribute("titulo", "Listado de albañiles");
            return "albaniles";
        }
    }


    /*
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
    */
    }
