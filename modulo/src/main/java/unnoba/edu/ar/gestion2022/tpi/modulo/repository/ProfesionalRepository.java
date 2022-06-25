package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;

import java.util.List;

public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    
}
