package pe.com.model.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table( name = "Equipo" )
public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito distrito;
	
	@Column(name="nombre",length=50,nullable=false)
	private String nombre;
	
	@Column(name="descripcion",length=100,nullable=false)
	private String descripcion;
	
	@Column(name="num_participantes",length=50,nullable=false)
	private int numparticipantes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_juego")
	private Date fechajuego;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumparticipantes() {
		return numparticipantes;
	}

	public void setNumparticipantes(int numparticipantes) {
		this.numparticipantes = numparticipantes;
	}

	public Date getFechajuego() {
		return fechajuego;
	}

	public void setFechajuego(Date fechajuego) {
		this.fechajuego = fechajuego;
	}
	
	
}
