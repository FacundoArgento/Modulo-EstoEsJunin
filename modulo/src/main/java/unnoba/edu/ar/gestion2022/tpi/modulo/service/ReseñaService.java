package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import java.util.List;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.ReseñaRepository;

public class ReseñaService implements ReseñaServiceImp {
    
    private ReseñaRepository reseñaRepository;



    public void guardarReseña(Reseña reseña){
        
        reseñaRepository.save(reseña);
    }



    public List<Reseña> getReseñas() {
        return null;
    }
}
