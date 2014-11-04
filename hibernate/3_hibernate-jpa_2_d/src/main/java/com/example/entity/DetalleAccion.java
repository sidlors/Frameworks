package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalles_acciones database table.
 * 
 */
@Entity
@Table(name="detalles_acciones")
@NamedQuery(name="DetalleAccion.findAll", query="SELECT d FROM DetalleAccion d")
public class DetalleAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_accion")
	private int idDetalleAccion;

	@Column(name="descripcion_compania")
	private String descripcionCompania;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_revision")
	private Date fechaRevision;

	@Column(name="nombre_compania")
	private String nombreCompania;

	//bi-directional one-to-one association to AccionBursatil
	@OneToOne
	@JoinColumn(name="id_accion_bursatil")
	private AccionBursatil accionBursatil;

	public DetalleAccion() {
	}

	public int getIdDetalleAccion() {
		return this.idDetalleAccion;
	}

	public void setIdDetalleAccion(int idDetalleAccion) {
		this.idDetalleAccion = idDetalleAccion;
	}

	public String getDescripcionCompania() {
		return this.descripcionCompania;
	}

	public void setDescripcionCompania(String descripcionCompania) {
		this.descripcionCompania = descripcionCompania;
	}

	public Date getFechaRevision() {
		return this.fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public String getNombreCompania() {
		return this.nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public AccionBursatil getAccionBursatil() {
		return this.accionBursatil;
	}

	public void setAccionBursatil(AccionBursatil accionBursatil) {
		this.accionBursatil = accionBursatil;
	}

}