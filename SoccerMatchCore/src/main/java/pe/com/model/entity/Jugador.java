package pe.com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Jugador" )
public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="jugador")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_calle")
	private Calle calle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}
	
	
}

