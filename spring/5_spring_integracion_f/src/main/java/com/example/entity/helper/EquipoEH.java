package com.example.entity.helper;

import com.example.entity.Equipo;

public class EquipoEH {

	static public String toString(Equipo equipo) {

		String toString = null;
		if (equipo != null) {
			toString = "Equipo [equipo.getIdEquipo()=" + equipo.getIdEquipo()
					+ ", equipo.getApodo()=" + equipo.getApodo()
					+ ", equipo.getDirectorTecnico()="
					+ equipo.getDirectorTecnico()
					+ ", equipo.getEstadioCasaDireccion()="
					+ equipo.getEstadioCasaDireccion()
					+ ", equipo.getEstadioCasaNombre()="
					+ equipo.getEstadioCasaNombre()
					+ ", equipo.getFechaBaja()=" + equipo.getFechaBaja()
					+ ", equipo.getFechaFundacion()="
					+ equipo.getFechaFundacion() + ", equipo.getNombre()="
					+ equipo.getNombre() + ", equipo.getPaginaWeb()="
					+ equipo.getPaginaWeb() + ", equipo.getPropietario()="
					+ equipo.getPropietario() + "]";
		}
		return toString;

	}
}
