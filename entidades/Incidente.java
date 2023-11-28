package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Incidentes")
public class Incidente implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="fk_operador")
	private Operador operador; 
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="fk_cliente")
	private Cliente cliente; 
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="fk_especialidad")
	private Especialidad especialidad; 
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_de_reporte")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDeReporte;
	
	@Column(name = "fecha_de_resolucion_estimada")
	@Temporal(TemporalType.DATE)
	private Date fechaDeResolucionEstimada;
	
	@Column(name = "fecha_en_que_fue_resuelta")
	@Temporal(TemporalType.DATE)
	private Date fechaEnQueFueResuelta;
		
	//Constructor vacio
	public Incidente()
	{
	}

	public Incidente(Operador operador, Cliente cliente, Especialidad especialidad, String descripcion,
			Date fechaDeReporte, Date fechaDeResolucionEstimada, Date fechaEnQueFueResuelta) {
		this.operador = operador;
		this.cliente = cliente;
		this.especialidad = especialidad;
		this.descripcion = descripcion;
		this.fechaDeReporte = fechaDeReporte;
		this.fechaDeResolucionEstimada = fechaDeResolucionEstimada;
		this.fechaEnQueFueResuelta = fechaEnQueFueResuelta;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Operador getOperador() {
		return operador;
	}



	public void setOperador(Operador operador) {
		this.operador = operador;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Especialidad getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Date getFechaDeReporte() {
		return fechaDeReporte;
	}



	public void setFechaDeReporte(Date fechaDeReporte) {
		this.fechaDeReporte = fechaDeReporte;
	}



	public Date getFechaDeResolucionEstimada() {
		return fechaDeResolucionEstimada;
	}



	public void setFechaDeResolucionEstimada(Date fechaDeResolucionEstimada) {
		this.fechaDeResolucionEstimada = fechaDeResolucionEstimada;
	}




	public Date getFechaEnQueFueResuelta() {
		return fechaEnQueFueResuelta;
	}



	public void setFechaEnQueFueResuelta(Date fechaEnQueFueResuelta) {
		this.fechaEnQueFueResuelta = fechaEnQueFueResuelta;
	}



	@Override
	public String toString() {
		return "Incidente [id=" + id + ", operador=" + operador + ", cliente=" + cliente + ", especialidad="
				+ especialidad + ", descripcion=" + descripcion + ", fechaDeReporte=" + fechaDeReporte
				+ ", fechaDeResolucionEstimada=" + fechaDeResolucionEstimada + ", fechaEnQueFueResuelta="
				+ fechaEnQueFueResuelta + "]";
	}





	
}
