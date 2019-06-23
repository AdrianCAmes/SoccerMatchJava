package com.soccermatch.SoccerMatch.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table( name = "Alquiler" )
public class Alquiler implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "SMALLINT(4)")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_equipo", nullable = false)
	private Equipo equipo;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cancha", nullable = false)
	private Cancha cancha;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="hora_inicio")//con este tipo de dato no se mas colocar(mejor no meto la pata)
	private Date horaInicio;
	
	@Min(value = 1, message = "minimo de alquiler 1 hora")
	@Max(value = 4, message = "maximo de alquiler 4 horas")
	@Column(name="num_horas", columnDefinition = "TINYINT(1)", nullable = false)
	private int numHoras;
	
	@Min(value = 0)
	@Max(value = 36, message = "maximo de descuento 36") //suponiendo
	@Column(name="descuento", nullable = false)
	private float descuento;	
	
	@Min(value = 20)
	@Max(value = 80, message = "monto por las 4 horas y sin descuento es de 80 soles") //suponiendo
	@Column(name="monto_total", nullable = false)
	private float total;	
	
	@Column(name="estado_pagado")
	private Boolean estadoPagado;
	
	@OneToMany(mappedBy = "alquiler", cascade = CascadeType.ALL)
	private List<DetalleParticipante> detalleparticipante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Boolean getEstadoPagado() {
		return estadoPagado;
	}

	public void setEstadoPagado(Boolean estadoPagado) {
		this.estadoPagado = estadoPagado;
	}
}
