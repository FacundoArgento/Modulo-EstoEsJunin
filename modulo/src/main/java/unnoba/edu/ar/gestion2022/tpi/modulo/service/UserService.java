package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.UserRepository;

import java.util.List;
import java.util.Locale;
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

    public List<User> listadoPlomeros() {
        String rubro = "Plomero";
        return userRepository.listaPlomeros(rubro);
    }

    public List<User> listadoPlomeros(String palabraClave) {
        String rubro = "Plomero";
        return userRepository.listaPlomeros(rubro, palabraClave.toLowerCase());
    }

    public List<User> listadoGasistas() {
        String rubro ="Gasista";
        return userRepository.listaGasista(rubro);
    }

    public List<User> listadoGasistas(String palabraClave){
        String rubro ="Gasista";
        return userRepository.listaGasista(rubro, palabraClave.toLowerCase());
    }


    public List<User> listadoAlbaniles(String palabraClave){
        String rubro ="Albañil";
        return userRepository.listaAlbanil(rubro, palabraClave.toLowerCase());
    }

    public List<User> listadoAlbaniles(){
        String rubro ="Albañil";
        return userRepository.listaAlbanil(rubro);
    }
    public List<User> listadoElectricistas(){
        String rubro ="Electricista";
        return userRepository.listaElectricista(rubro);
    }

    public List<User> listadoElectricistas(String palabraClave){
        String rubro ="Electricista";
        return userRepository.listaElectricista(rubro, palabraClave.toLowerCase());
    }

    public User findId(Long id){
        return userRepository.findId(id);
    }

}
