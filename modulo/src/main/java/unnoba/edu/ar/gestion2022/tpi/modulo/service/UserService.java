package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private UserRepository userRepository;

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userServiceImp.create(user);
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public User replaceUser(User user, Long id) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setEmail(user.getEmail());
                    u.setPassword(user.getPassword());
                    u.setNombre(user.getNombre());
                    u.setApellido(user.getApellido());
                    return userRepository.save(u);
                })
                .orElseGet(() -> {
                    return userRepository.save(user);
                });
    }

    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Long findUserIDByUsername(String username) {
        return userRepository.findUserIDByUsername(username);
    }

    public List<User> listadoPlomeros(){
        String rubro ="Plomero";
        return userRepository.listaPlomeros(rubro);
    }

    public List<User> listadoGasistas(){
        return userRepository.listaGasista();
    }

    public List<User> listadoAlbaniles(){
        return userRepository.listaAlbanil();
    }
    public List<User> listadoElectricistas(){
        return userRepository.listaElectricista();
    }

    
}
