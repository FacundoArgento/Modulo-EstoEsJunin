package unnoba.edu.ar.gestion2022.tpi.modulo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesionales")
public class Profesional {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nombre")
	private String nombre;

    @Column(name = "rubro")
	private String rubro;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "telefono_alternativo")
	private String telefono_alternativo;
	
	@Column(name = "direccion")
	private String direccion;


	// getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono_alternativo() {
		return telefono_alternativo;
	}

	public void setTelefono_alternativo(String telefono_alternativo) {
		this.telefono_alternativo = telefono_alternativo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
