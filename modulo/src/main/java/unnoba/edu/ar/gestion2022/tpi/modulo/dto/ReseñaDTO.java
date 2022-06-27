package unnoba.edu.ar.gestion2022.tpi.modulo.dto;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Seccion;
import unnoba.edu.ar.gestion2022.tpi.modulo.model.User;

public class ReseñaDTO {

    private long id;
    private String titulo;
    private String text;
    private float valoracion;
    private Seccion seccion;

    public ReseñaDTO(String titulo, String text, float valoracion, Seccion seccion, User user) {
        
        this.titulo = titulo;
        this.text = text;
        this.valoracion = valoracion;
        this.seccion = seccion;
        
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public float getValoracion() {
        return valoracion;
    }
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    public Seccion getSeccion() {
        return seccion;
    }
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

}
