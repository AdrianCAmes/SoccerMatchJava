package pe.com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Usuario" )
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_jugador",nullable=false)
	private Jugador jugador;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_propietario",nullable=false)
	private Propietario propietario;
	
	@Column(name="dni")
	private int dni;
	
	@Column(name="nombre",length=50,nullable=false)
	private String nombre;
	
	@Column(name="num_telefono")
	private int numtelefono;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumtelefono() {
		return numtelefono;
	}

	public void setNumtelefono(int numtelefono) {
		this.numtelefono = numtelefono;
	}
	
	
}

