package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import unnoba.edu.ar.gestion2022.tpi.modulo.dto.ReseñaDTO;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.ReseñaRepository;

@Service
public class ReseñaService implements ReseñaServiceImp {
    @Autowired
    private ReseñaRepository reseñaRepository;
    @Autowired
    private ReseñaServiceImp reseñaServiceImp;

    public void guardarReseña(Reseña reseña){
        reseñaRepository.save(reseña);
    }



     public List<Reseña> getReseñasPorUser(Long id) {
         return reseñaRepository.getReseñasByUserID(id);
     }



    public void eliminarReseñaPorId(@PathVariable Long reseñaId) {
        reseñaRepository.deleteById(reseñaId);

    }

}
