package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
