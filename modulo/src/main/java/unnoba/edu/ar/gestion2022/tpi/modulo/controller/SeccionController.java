package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;

@Controller
public class SeccionController {
    @Autowired
    private UserService userSer;
    @GetMapping("/seccion")
    public String seccion(Model model) {
        model.addAttribute("titulo", "Listado de profesionales");
        return "seccion";}

    @GetMapping("/seccion/{id}")
    public String seccion2(@PathVariable(value = "id") Long id, Model model ) {
        User user =userSer.findId(id);
        model.addAttribute("titulo", user.getNombre()+" "+user.getApellido()  );
        model.addAttribute("usuario",user);
        return "seccion";}
}


