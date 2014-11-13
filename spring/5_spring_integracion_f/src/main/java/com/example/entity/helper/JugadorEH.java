package com.example.entity.helper;

import com.example.entity.Jugador;

public class JugadorEH {

	static public String toString(Jugador jugador) {

		String toString = null;
		if (jugador != null) {
			toString = "Equipo [jugador.getIdJugador()="
					+ jugador.getIdJugador()
					+ ", jugador.getApellidoMaterno()="
					+ jugador.getApellidoMaterno()
					+ ", jugador.getApellidoPaterno()="
					+ jugador.getApellidoPaterno()
					+ ", jugador.getFechaNacimiento()="
					+ jugador.getFechaNacimiento() + ", jugador.getNombre()="
					+ jugador.getNombre() + ", jugador.getNumeroCamiseta()="
					+ jugador.getNumeroCamiseta() + "]";
		}
		return toString;

	}
}
