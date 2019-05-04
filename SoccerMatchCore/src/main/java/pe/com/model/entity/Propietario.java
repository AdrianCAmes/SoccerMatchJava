package pe.com.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Propietario" )
public class Propietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@JoinColumn(name = "id", nullable = false)
	@OneToOne(cascade=CascadeType.ALL,mappedBy="propietario")
	private Usuario usuario;

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
	
	
}

