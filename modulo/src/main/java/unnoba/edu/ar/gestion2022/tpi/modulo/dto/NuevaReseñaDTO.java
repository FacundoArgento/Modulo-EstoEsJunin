package unnoba.edu.ar.gestion2022.tpi.modulo.dto;

import org.apache.catalina.User;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Seccion;

public class NuevaReseñaDTO {
    
    private String titulo;
    private String text;
    private float valoracion;
    private Seccion seccion;

    public NuevaReseñaDTO(String titulo, String text, float valoracion, Seccion seccion, User user) {
        
        this.titulo = titulo;
        this.text = text;
        this.valoracion = valoracion;
        this.seccion = seccion;
        
    }

    public NuevaReseñaDTO(){
        
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
