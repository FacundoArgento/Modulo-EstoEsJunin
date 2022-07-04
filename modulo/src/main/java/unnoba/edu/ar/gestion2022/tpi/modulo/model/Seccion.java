package unnoba.edu.ar.gestion2022.tpi.modulo.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="secciones")
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seccion_id")
    private long id;

    @Column(name = "razon_social")
	private String razon_social;
	
	@Column(name = "redes_sociales")
	private String redes_sociales;

    @Column(name = "horarios")
    private String horarios;
	
	@Column(name = "descripcion")
	private String descripcion;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private User user;

    public Seccion() {

    }

    public Seccion(long id, String razon_social, String redes_sociales, String horarios, String descripcion, User user) {
        this.id = id;
        this.razon_social = razon_social;
        this.redes_sociales = redes_sociales;
        this.horarios = horarios;
        this.descripcion = descripcion;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRedes_sociales() {
        return redes_sociales;
    }

    public void setRedes_sociales(String redes_sociales) {
        this.redes_sociales = redes_sociales;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
