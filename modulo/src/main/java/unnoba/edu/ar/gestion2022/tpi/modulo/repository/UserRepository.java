package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User findUserByUsername(@Param("username") String username);

    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    public Long findUserIDByUsername(@Param("username") String username);
    
}
