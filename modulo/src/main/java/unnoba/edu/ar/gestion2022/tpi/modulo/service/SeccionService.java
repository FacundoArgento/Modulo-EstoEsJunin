package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Seccion;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.ReseñaRepository;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.SeccionRepository;

@Service
public class SeccionService implements SeccionServiceImp {

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private SeccionServiceImp seccionServiceImp;

    public void addSeccion(Seccion seccion) {
        seccionRepository.save(seccion);
    }

    public Seccion getSeccionByUserID(Long id) {
        return seccionRepository.getSeccionByUserID(id);
    }

    public void eliminarSeccionPorId(@PathVariable Long seccionId) {
        seccionRepository.deleteById(seccionId);
    }
    
}
