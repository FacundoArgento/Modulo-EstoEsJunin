package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;

public interface ReseñaRepository extends JpaRepository<Reseña, Long>{

    @Query("SELECT r FROM Reseñas r INNER JOIN Seccion s ON :id = s.id")
    List<Reseña> getReseñasBySeccionID();  //FALTA MODELAR SECCION PARA AGREGAR EL PARAMETRO Seccion Id..

    @Query("SELECT r FROM Reseñas r WHERE r.id = :id")
    void findReseñaByID(@Param("id")long id);

    @Query("DELETE FROM Reseñas r WHERE r.id = :id")
    void eliminarReseñaByID(@Param("id") long id);
    
}
