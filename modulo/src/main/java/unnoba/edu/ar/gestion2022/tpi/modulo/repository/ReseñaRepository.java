package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Reseña;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {

     @Query("SELECT r FROM Reseña r WHERE r.user.id = ?1")
     List<Reseña> getReseñasByUserID(Long id);

     /*@Query("SELECT r FROM Reseñas r WHERE r.id = :id")
     void findReseñaByID(@Param("id")long id);

     @Query("DELETE FROM Reseñas r WHERE r.id = :id")
     void eliminarReseñaByID(@Param("id") long id);*/

}
