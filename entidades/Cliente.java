package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "CUIT")
	private String CUIT;

	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "domicilio")
	private String domicilio;
		
	//Constructor vacio
	public Cliente()
	{
	}




	public Cliente(String razonSocial, String cUIT, String telefono, String email, String dni, String domicilio) {
		this.razonSocial = razonSocial;
		CUIT = cUIT;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
		this.domicilio = domicilio;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getDomicilio() {
		return domicilio;
	}




	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}




	@Override
	public String toString() {
		return "Cliente [id=" + id + ", razonSocial=" + razonSocial + ", CUIT=" + CUIT + ", telefono=" + telefono
				+ ", email=" + email + ", dni=" + dni + ", domicilio=" + domicilio + "]";
	}
	
	
	
	
	
	

	
	
	
	
}
