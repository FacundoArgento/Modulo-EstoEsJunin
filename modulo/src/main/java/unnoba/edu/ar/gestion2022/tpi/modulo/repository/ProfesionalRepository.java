package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {

    @Query("SELECT p FROM Profesional p WHERE p.id = :id")
    public Profesional findProfesionalById(@Param("id") long id);

}
