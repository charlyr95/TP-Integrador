package entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tecnicos")
public class Tecnico implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "documento")
	private String documento;

	@Column(name = "email")
	private String email;

	@Column(name = "sueldo")
	private double sueldo;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="fk_especialidad")
	private Especialidad especialidad;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="tecnicos_x_incidentes",joinColumns= {@JoinColumn(name="id_tecnico")}, inverseJoinColumns= {@JoinColumn(name="id_incidente")})
	private Set<Incidente> listaIncidentes = new HashSet<Incidente>(); 
	
		
	//Constructor vacio
	public Tecnico()
	{
	}
	

	public Tecnico(String nombre, String apellido, String documento, String email, double sueldo,
			Especialidad especialidad, Set<Incidente> listaIncidentes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.sueldo = sueldo;
		this.especialidad = especialidad;
		this.listaIncidentes = listaIncidentes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public Set<Incidente> getListaIncidentes() {
		return listaIncidentes;
	}


	public void setListaIncidentes(Set<Incidente> listaIncidentes) {
		this.listaIncidentes = listaIncidentes;
	}


	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", email=" + email + ", sueldo=" + sueldo + ", especialidad=" + especialidad + ", listaIncidentes="
				+ listaIncidentes + "]";
	}


	
	


	
}
