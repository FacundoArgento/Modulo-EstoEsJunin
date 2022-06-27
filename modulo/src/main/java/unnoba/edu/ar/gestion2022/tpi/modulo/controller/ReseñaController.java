package unnoba.edu.ar.gestion2022.tpi.modulo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unnoba.edu.ar.gestion2022.tpi.modulo.dto.NuevaReseñaDTO;
import unnoba.edu.ar.gestion2022.tpi.modulo.dto.ReseñaDTO;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.ReseñaService;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.SeccionService;
import unnoba.edu.ar.gestion2022.tpi.modulo.service.UserService;

@Controller
@RequestMapping("/reseñas")
public class ReseñaController {

    private SeccionService seccionService;  // A IMPLEMENTAR
    private ReseñaService reseñaService;
    private static ModelMapper modelMapper;

    
    public ReseñaController(SeccionService seccionService, ReseñaService reseñaService) {
        this.seccionService = seccionService;
        this.reseñaService = reseñaService;
    }

    // mostrar reseñas en la pagina
    @PostMapping("/show")
    public String mostrarReseñas(Model model){
        List<Reseña> reseñas= new ArrayList<>();
	    // reseñas = reseñaService.getReseñasPorSeccion();     // FALTARIA MODELAR SECCION PARA COMPLETAR.. y pasar el id
		
		List<ReseñaDTO> reseñasDTO = reseñas.stream()
                .map(reseña -> modelMapper.map(reseña, ReseñaDTO.class))
				.collect(Collectors.toList());
		
		model.addAttribute("reseñas", reseñasDTO);
		model.addAttribute("nuevaReseña", new NuevaReseñaDTO());
		return "bookings/availability";
    }

    // crear reseña
    @PostMapping("/crearReseña")
	public String crearReseña(@ModelAttribute NuevaReseñaDTO reseñaDTO, Authentication authentication, Model model) {
		
        Reseña reseña = modelMapper.map(reseñaDTO, Reseña.class);
		
        // ver que sucede con el ID

        reseña.setUsuario((User)authentication.getPrincipal());
		try {
			
			reseñaService.guardarReseña(reseña);
			return "?";
		
		} catch (Exception e) {
			System.out.println("No se pudo realizar la reseña.");
			return "?";
		}
		
	}
    // eliminar reseña
    @PostMapping("/eliminarReseña")
    public String eliminarReseña(@ModelAttribute ReseñaDTO reseñaDTO, Model model){
        reseñaService.eliminarReseñaPorId(reseñaDTO.getId());
        return "?"
;    }
    
    
}
