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
@Table( name = "Alquiler" )
public class Alquiler implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_equipo", nullable = false)
	private Equipo equipo;	
	
	@ManyToOne
	private Cancha cancha;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio")
	private Date horaInicio;
	
	@Column(name="num_horas")
	private int numHoras;
	
	@Column(name="descuento")
	private float descuento;	
	
	@Column(name="monto_total")
	private float total;	
	
	@Column(name="estado_pagado")
	private Boolean estadoPagado;

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
