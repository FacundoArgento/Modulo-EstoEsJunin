package unnoba.edu.ar.gestion2022.tpi.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User findUserByUsername(@Param("username") String username);

    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    public Long findUserIDByUsername(@Param("username") String username);
    @Query("SELECT u FROM User u WHERE u.rubro= ?1")
    public List<User> listaPlomeros(String rubro);

    @Query("SELECT u FROM User u WHERE u.rubro= ?1 AND (lower(u.nombre) LIKE %?2%"
            + "OR lower(u.apellido) LIKE %?2%)")
    public List<User> listaPlomeros(String rubro, String palabraClave);


    @Query("SELECT u FROM User u WHERE u.rubro= ?1")
    public List<User> listaAlbanil(String rubro);

    @Query("SELECT u FROM User u WHERE u.rubro= ?1 AND (lower(u.nombre) LIKE %?2%"
            + "OR lower(u.apellido) LIKE %?2%)")
    public List<User> listaAlbanil(String rubro, String palabraClave);

    @Query("SELECT u FROM User u WHERE u.rubro= ?1")
    public List<User> listaElectricista(String rubro);

    @Query("SELECT u FROM User u WHERE u.rubro= ?1 AND (lower(u.nombre) LIKE %?2%"
            + "OR lower(u.apellido) LIKE %?2%)")
    public List<User> listaElectricista(String rubro, String palabraClave);

    @Query("SELECT u FROM User u WHERE u.rubro= ?1")
    public List<User> listaGasista(String rubro);
    @Query("SELECT u FROM User u WHERE u.rubro= ?1 AND (lower(u.nombre) LIKE %?2%"
            + "OR lower(u.apellido) LIKE %?2%)")
    public List<User> listaGasista(String rubro, String palabraClave);

    @Query("SELECT u FROM User u WHERE u.id=?1  ")
    public User findId(Long id);

}
