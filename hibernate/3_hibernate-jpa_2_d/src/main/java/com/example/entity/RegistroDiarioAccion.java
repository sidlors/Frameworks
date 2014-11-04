package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the registros_diarios_acciones database table.
 * 
 */
@Entity
@Table(name="registros_diarios_acciones")
@NamedQuery(name="RegistroDiarioAccion.findAll", query="SELECT r FROM RegistroDiarioAccion r")
public class RegistroDiarioAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_registro_diario_accion")
	private int idRegistroDiarioAccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name="precio_apertura")
	private double precioApertura;

	@Column(name="precio_cierre")
	private double precioCierre;

	//bi-directional many-to-one association to AccionBursatil
	@ManyToOne
	@JoinColumn(name="id_accion_bursatil")
	private AccionBursatil accionBursatil;

	//bi-directional many-to-one association to VariacionDiaria
	@OneToMany(mappedBy="registroDiarioAccion", cascade={CascadeType.ALL})
	private List<VariacionDiaria> variacionesDiarias;

	public RegistroDiarioAccion() {
	}

	public int getIdRegistroDiarioAccion() {
		return this.idRegistroDiarioAccion;
	}

	public void setIdRegistroDiarioAccion(int idRegistroDiarioAccion) {
		this.idRegistroDiarioAccion = idRegistroDiarioAccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecioApertura() {
		return this.precioApertura;
	}

	public void setPrecioApertura(double precioApertura) {
		this.precioApertura = precioApertura;
	}

	public double getPrecioCierre() {
		return this.precioCierre;
	}

	public void setPrecioCierre(double precioCierre) {
		this.precioCierre = precioCierre;
	}

	public AccionBursatil getAccionBursatil() {
		return this.accionBursatil;
	}

	public void setAccionBursatil(AccionBursatil accionBursatil) {
		this.accionBursatil = accionBursatil;
	}

	public List<VariacionDiaria> getVariacionesDiarias() {
		return this.variacionesDiarias;
	}

	public void setVariacionesDiarias(List<VariacionDiaria> variacionesDiarias) {
		this.variacionesDiarias = variacionesDiarias;
	}

	public VariacionDiaria addVariacionesDiaria(VariacionDiaria variacionesDiaria) {
		getVariacionesDiarias().add(variacionesDiaria);
		variacionesDiaria.setRegistroDiarioAccion(this);

		return variacionesDiaria;
	}

	public VariacionDiaria removeVariacionesDiaria(VariacionDiaria variacionesDiaria) {
		getVariacionesDiarias().remove(variacionesDiaria);
		variacionesDiaria.setRegistroDiarioAccion(null);

		return variacionesDiaria;
	}

}