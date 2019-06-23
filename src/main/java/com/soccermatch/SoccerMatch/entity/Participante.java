package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "Participante" )
public class Participante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_jugador",nullable=false)
	private Jugador jugador;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_equipo",nullable=false)
	private Equipo equipo;
	
	@Column(name="es_administrador")
	private Boolean esadministrador;

	@NotNull
	@OneToMany(mappedBy = "participante", cascade = CascadeType.ALL)
	private List<DetalleParticipante> detalleparticipante;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Boolean getEsadministrador() {
		return esadministrador;
	}

	public void setEsadministrador(Boolean esadministrador) {
		this.esadministrador = esadministrador;
	}
	
	
}
