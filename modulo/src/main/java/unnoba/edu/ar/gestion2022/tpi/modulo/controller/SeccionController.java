package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.ReseñaService;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;

import java.util.List;

@Controller
public class SeccionController {
    @Autowired
    private UserService userSer;
    @Autowired
    private ReseñaService reseñaService;
    @GetMapping("/seccion")
    public String seccion(Model model) {
        Reseña reseña = new Reseña();
        model.addAttribute("titulo", "Listado de profesionales");
        model.addAttribute("resenia", reseña);
        return "seccion";}

    @GetMapping("/seccion/{id}")
    public String seccion2(@PathVariable(value = "id") Long id, Model model ) {
        Reseña reseña = new Reseña();
        User user =userSer.findId(id);
        List<Reseña>reseñas = reseñaService.getReseñasPorUser(user.getId());
        Double promedio = reseñaService.promedios(reseñas);
        model.addAttribute("titulo", user.getNombre()+" "+user.getApellido()  );
        model.addAttribute("usuario",user);
        model.addAttribute("resenia", reseña);
        model.addAttribute("listado",reseñas);
        model.addAttribute("promedio",promedio);
        return "seccion";
    }

    @PostMapping("/seccion/{id}")
    public String addReseña(@ModelAttribute Reseña resenia, Model model,@PathVariable Long id) {
        User user = userSer.findId(id);
        Reseña nueva = new Reseña();
        nueva.setTexto(resenia.getTexto());
        nueva.setValoracion(resenia.getValoracion());
        nueva.setUsuario(user);
        reseñaService.guardarReseña(nueva);
        return "redirect:/seccion/" + id;
    }
}


