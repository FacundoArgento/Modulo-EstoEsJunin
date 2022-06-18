package unnoba.edu.ar.gestion2022.tpi.modulo.userDetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserLoggedIn extends User {

    private unnoba.edu.ar.gestion2022.tpi.modulo.model.User user;

    public UserLoggedIn(String username, String password, Collection<? extends GrantedAuthority> authorities, unnoba.edu.ar.gestion2022.tpi.modulo.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public unnoba.edu.ar.gestion2022.tpi.modulo.model.User getUser() {
        return user;
    }

    public void setUser(unnoba.edu.ar.gestion2022.tpi.modulo.model.User user) {
        this.user = user;
    }

}
