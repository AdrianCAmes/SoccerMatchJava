package pe.com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
<<<<<<< HEAD

	@JoinColumn(name = "usuario_id", nullable = false)
	@OneToOne(cascade=CascadeType.ALL,mappedBy="jugador")
=======
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="jugador")
	@JoinColumn(name = "id", nullable = false)
>>>>>>> 1f627ee8ca090a621cb5e99724a64fd5335fa69f
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_calle")
	private Calle calle;


	@Column(name="direccion",length=100,nullable=false)
	private String Direccion;
	
	public Integer getId() {
		return id;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
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

