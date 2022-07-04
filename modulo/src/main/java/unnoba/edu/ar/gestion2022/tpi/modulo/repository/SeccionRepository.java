package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Seccion;

import java.util.List;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Long> {

    @Query("SELECT s FROM Seccion s WHERE s.user.id = ?1")
    Seccion getSeccionByUserID(Long id);

}
