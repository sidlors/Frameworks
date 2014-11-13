package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the equipos database table.
 * 
 */
@Entity
@Table(name="equipos")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_equipo")
	private int idEquipo;

	private String apodo;

	@Column(name="director_tecnico")
	private String directorTecnico;

	@Column(name="estadio_casa_direccion")
	private String estadioCasaDireccion;

	@Column(name="estadio_casa_nombre")
	private String estadioCasaNombre;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fundacion")
	private Date fechaFundacion;

	private String nombre;

	@Column(name="pagina_web")
	private String paginaWeb;

	private String propietario;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipo", cascade={CascadeType.ALL})
	private List<Jugador> jugadores;

	public Equipo() {
	}

	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getApodo() {
		return this.apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getDirectorTecnico() {
		return this.directorTecnico;
	}

	public void setDirectorTecnico(String directorTecnico) {
		this.directorTecnico = directorTecnico;
	}

	public String getEstadioCasaDireccion() {
		return this.estadioCasaDireccion;
	}

	public void setEstadioCasaDireccion(String estadioCasaDireccion) {
		this.estadioCasaDireccion = estadioCasaDireccion;
	}

	public String getEstadioCasaNombre() {
		return this.estadioCasaNombre;
	}

	public void setEstadioCasaNombre(String estadioCasaNombre) {
		this.estadioCasaNombre = estadioCasaNombre;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaFundacion() {
		return this.fechaFundacion;
	}

	public void setFechaFundacion(Date fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Jugador addJugadore(Jugador jugadore) {
		getJugadores().add(jugadore);
		jugadore.setEquipo(this);

		return jugadore;
	}

	public Jugador removeJugadore(Jugador jugadore) {
		getJugadores().remove(jugadore);
		jugadore.setEquipo(null);

		return jugadore;
	}

}