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
    private long id;

    @Column(name = "nombre")
	private String nombre;
	
	@Column(name = "pagina_web")
	private String pagina_web;
	
	@Column(name = "redes_sociales")
	private String redes_sociales;
	
	@Column(name = "descripcion")
	private String descripcion;

    @Column(name= "foto")
    private File foto;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "profesional_id")
    private Profesional profesional;

    
    public Seccion(long id, String nombre, String pagina_web, String redes_sociales, String descripcion, File foto,
            Profesional profesional) {
        this.id = id;
        this.nombre = nombre;
        this.pagina_web = pagina_web;
        this.redes_sociales = redes_sociales;
        this.descripcion = descripcion;
        this.foto = foto;
        this.profesional = profesional;
    }

    //getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getRedes_sociales() {
        return redes_sociales;
    }

    public void setRedes_sociales(String redes_sociales) {
        this.redes_sociales = redes_sociales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public Profesional getId_profesional() {
        return profesional;
    }

    public void setId_profesional(Profesional profesional) {
        this.profesional = profesional;
    }

}
