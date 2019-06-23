package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "Propietario" )
public class Propietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_propietario", nullable = false)
	@NotNull
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

