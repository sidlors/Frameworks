package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="id_accion_bursatil")
	private int idAccionBursatil;

	@Column(name="codigo_accion")
	private String codigoAccion;

	@Column(name="nombre_accion")
	private String nombreAccion;

	//bi-directional many-to-many association to Categoria
	@ManyToMany(mappedBy="accionesBursatiles")
	private List<Categoria> categorias;

	//bi-directional one-to-one association to DetalleAccion
	@OneToOne(mappedBy="accionBursatil", cascade={CascadeType.ALL})
	private DetalleAccion detalleAccion;

	//bi-directional many-to-one association to RegistroDiarioAccion
	@OneToMany(mappedBy="accionBursatil", cascade={CascadeType.ALL})
	private List<RegistroDiarioAccion> registrosDiariosAcciones;

	public AccionBursatil() {
	}

	public int getIdAccionBursatil() {
		return this.idAccionBursatil;
	}

	public void setIdAccionBursatil(int idAccionBursatil) {
		this.idAccionBursatil = idAccionBursatil;
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

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public DetalleAccion getDetalleAccion() {
		return this.detalleAccion;
	}

	public void setDetalleAccion(DetalleAccion detalleAccion) {
		this.detalleAccion = detalleAccion;
	}

	public List<RegistroDiarioAccion> getRegistrosDiariosAcciones() {
		return this.registrosDiariosAcciones;
	}

	public void setRegistrosDiariosAcciones(List<RegistroDiarioAccion> registrosDiariosAcciones) {
		this.registrosDiariosAcciones = registrosDiariosAcciones;
	}

	public RegistroDiarioAccion addRegistrosDiariosAccione(RegistroDiarioAccion registrosDiariosAccione) {
		getRegistrosDiariosAcciones().add(registrosDiariosAccione);
		registrosDiariosAccione.setAccionBursatil(this);

		return registrosDiariosAccione;
	}

	public RegistroDiarioAccion removeRegistrosDiariosAccione(RegistroDiarioAccion registrosDiariosAccione) {
		getRegistrosDiariosAcciones().remove(registrosDiariosAccione);
		registrosDiariosAccione.setAccionBursatil(null);

		return registrosDiariosAccione;
	}

}