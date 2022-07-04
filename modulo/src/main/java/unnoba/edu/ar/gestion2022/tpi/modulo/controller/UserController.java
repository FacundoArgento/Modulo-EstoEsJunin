package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    // Formulario de login
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("titulo", "Ingreso de usuario");
        return "login";
    }

    // Formulario de login con error
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("titulo", "Ingreso de usuario");
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userservice.retrieveAllUsers();
    }

    @GetMapping("/users/new")
    public String crearUsuario(Model model){
        model.addAttribute("User", new User());
        model.addAttribute("titulo", "Registro de usuario");
        return "form";
    }

    @PostMapping("/users/new")
    public String addUser(@ModelAttribute User user, Model model) {
        model.addAttribute("User", user);
        user.setRole("USER");
        userservice.addUser(user);
        return "redirect:/login";
    }
    
}
