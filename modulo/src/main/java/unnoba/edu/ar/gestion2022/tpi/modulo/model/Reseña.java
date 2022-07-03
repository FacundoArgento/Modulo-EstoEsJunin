package unnoba.edu.ar.gestion2022.tpi.modulo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reseñas")
public class Reseña {

    public Reseña() {
    }

    public Reseña(long id, String texto, float valoracion, User user) {
        this.id = id;
        this.texto = texto;
        this.valoracion = valoracion;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reseña_id")
    private long id;
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "valoracion")
	private float valoracion;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable = false)
    private User user;

    // getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }

    

}
