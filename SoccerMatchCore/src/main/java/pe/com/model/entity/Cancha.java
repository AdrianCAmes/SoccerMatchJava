package pe.com.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Cancha" )
public class Cancha implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_propietario",nullable=false)
	private Propietario propietario;
	
	@ManyToOne
	@JoinColumn(name="id_calle",nullable=false)
	private Calle calle;
	
	@Column(name="nombre",length=50,nullable=false)
	private String nombre;
	
	@Column(name="direccion",length=100,nullable=false)
	private String direccion;
	
	@Column(name="precio_hora")
	private int precio_hora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getPrecio_hora() {
		return precio_hora;
	}

	public void setPrecio_hora(int precio_hora) {
		this.precio_hora = precio_hora;
	}
	
	
	
	
}
