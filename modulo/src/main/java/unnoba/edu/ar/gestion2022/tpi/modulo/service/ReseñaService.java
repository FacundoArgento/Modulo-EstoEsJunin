package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import unnoba.edu.ar.gestion2022.tpi.modulo.dto.ReseñaDTO;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.ReseñaRepository;

public class ReseñaService implements ReseñaServiceImp {
    
    private ReseñaRepository reseñaRepository;



    public void guardarReseña(Reseña reseña){
        reseñaRepository.save(reseña);
    }



    public List<Reseña> getReseñasPorSeccion() {
        
        return reseñaRepository.getReseñasBySeccionID();  //FALTA MODELAR SECCION PARA COMPLETAR..
    }



    public void eliminarReseñaPorId(@PathVariable Long reseñaId) {
        reseñaRepository.deleteById(reseñaId);

    }

}
