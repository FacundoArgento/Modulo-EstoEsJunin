package unnoba.edu.ar.gestion2022.tpi.modulo.model;

import javax.persistence.*;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reporte_id")
    private long id;

    @Column(name = "respuesta")
    private String respuesta;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="reseña_id")
    private Reseña reseña;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private User user;

    public Reporte() {
    }

    public Reporte(long id, String respuesta, Reseña reseña, User user) {
        this.id = id;
        this.respuesta = respuesta;
        this.reseña = reseña;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Reseña getReseña() {
        return reseña;
    }

    public void setReseña(Reseña reseña) {
        this.reseña = reseña;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
