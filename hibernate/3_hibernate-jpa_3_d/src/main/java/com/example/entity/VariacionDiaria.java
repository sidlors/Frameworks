package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the variaciones_diarias database table.
 * 
 */
@Entity
@Table(name="variaciones_diarias")
@NamedQuery(name="VariacionDiaria.findAll", query="SELECT v FROM VariacionDiaria v")
public class VariacionDiaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_variacion_diaria")
	private int idVariacionDiaria;

	private double variacion;

	//bi-directional many-to-one association to RegistroDiarioAccion
	@ManyToOne
	@JoinColumn(name="id_registro_diario_accion")
	private RegistroDiarioAccion registroDiarioAccion;

	public VariacionDiaria() {
	}

	public int getIdVariacionDiaria() {
		return this.idVariacionDiaria;
	}

	public void setIdVariacionDiaria(int idVariacionDiaria) {
		this.idVariacionDiaria = idVariacionDiaria;
	}

	public double getVariacion() {
		return this.variacion;
	}

	public void setVariacion(double variacion) {
		this.variacion = variacion;
	}

	public RegistroDiarioAccion getRegistroDiarioAccion() {
		return this.registroDiarioAccion;
	}

	public void setRegistroDiarioAccion(RegistroDiarioAccion registroDiarioAccion) {
		this.registroDiarioAccion = registroDiarioAccion;
	}

}