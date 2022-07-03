package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        List<User> list =userRepository.listaPlomeros(rubro);
        list= ordenar(list);
        return list;
    }

    public List<User> listadoPlomeros(String palabraClave) {
        String rubro = "Plomero";
        List<User> list =userRepository.listaPlomeros(rubro, palabraClave.toLowerCase());
        list= ordenar(list);
        return list;
    }

    public List<User> listadoGasistas() {
        String rubro ="Gasista";
        List<User> list =userRepository.listaGasista(rubro);
        list= ordenar(list);
        return list;
    }

    public List<User> listadoGasistas(String palabraClave){
        String rubro ="Gasista";
        List<User> list =userRepository.listaGasista(rubro,palabraClave.toLowerCase());
        list= ordenar(list);
        return list;
    }


    public List<User> listadoAlbaniles(String palabraClave){
        String rubro ="Albañil";
        List<User> list =userRepository.listaAlbanil(rubro,palabraClave.toLowerCase());
        list= ordenar(list);
        return list;
    }

    public List<User> listadoAlbaniles(){
        String rubro ="Albañil";
        List<User> list =userRepository.listaAlbanil(rubro);
        list= ordenar(list);
        return list;
    }
    public List<User> listadoElectricistas(){
        String rubro ="Electricista";
        List<User> list =userRepository.listaElectricista(rubro);
        list= ordenar(list);
        return list;
    }

    public List<User> listadoElectricistas(String palabraClave){
        String rubro ="Electricista";
        List<User> list =userRepository.listaElectricista(rubro,palabraClave.toLowerCase());
        list= ordenar(list);
        return list;
    }

    public User findId(Long id){
        return userRepository.findId(id);
    }


    public List<User> ordenar(List<User> list){
        List<User> lista =list.stream()
                .sorted(Comparator.comparing(User::getNombre))
                .collect(Collectors.toList());
        return lista;
    }
}
