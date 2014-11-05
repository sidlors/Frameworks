package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int idCategoria;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to AccionBursatil
	@ManyToMany
	@JoinTable(
		name="acciones_categorias"
		, joinColumns={
			@JoinColumn(name="id_categoria")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_accion_bursatil")
			}
		)
	private List<AccionBursatil> accionesBursatiles;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AccionBursatil> getAccionesBursatiles() {
		return this.accionesBursatiles;
	}

	public void setAccionesBursatiles(List<AccionBursatil> accionesBursatiles) {
		this.accionesBursatiles = accionesBursatiles;
	}

}