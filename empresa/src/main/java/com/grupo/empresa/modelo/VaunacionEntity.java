package com.grupo.empresa.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carnet")
public class VaunacionEntity {

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	//@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "dosis", nullable = false)
	private int dosis;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "cedula", nullable = false)
	private String cedula;

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
