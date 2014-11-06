package com.example.entity.helper;

import com.example.entity.AccionBursatil;

public class AccionBursatilEH {

	static public String toString(AccionBursatil accionBursatil) {

		String toString = null;
		if (accionBursatil != null) {
			toString = "AccionBursatil [idAccionBursatil="
					+ accionBursatil.getIdAccionBursatil() + ", codigoAccion="
					+ accionBursatil.getCodigoAccion() + ", nombreAccion="
					+ accionBursatil.getNombreAccion() + "]";
		}
		return toString;
	}

}
