package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acciones_bursatiles database table.
 * 
 */
@Entity
@Table(name="acciones_bursatiles")
@NamedQuery(name="AccionBursatil.findAll", query="SELECT a FROM AccionBursatil a")
public class AccionBursatil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_accion")
	private int idAccion;

	@Column(name="codigo_accion")
	private String codigoAccion;

	@Column(name="nombre_accion")
	private String nombreAccion;

	public AccionBursatil() {
	}

	public int getIdAccion() {
		return this.idAccion;
	}

	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}

	public String getCodigoAccion() {
		return this.codigoAccion;
	}

	public void setCodigoAccion(String codigoAccion) {
		this.codigoAccion = codigoAccion;
	}

	public String getNombreAccion() {
		return this.nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

}