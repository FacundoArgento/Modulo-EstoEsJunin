package unnoba.edu.ar.gestion2022.tpi.modulo.service;
import java.util.List;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;

public interface ReseñaServiceImp {
    
    public void guardarReseña(Reseña reseña);

    // public List<Reseña> getReseñasPorSeccion();

    public void eliminarReseñaPorId(Long id);
}   
