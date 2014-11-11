package com.example.entity.helper;

import com.example.entity.VariacionDiaria;

public class VariacionDiariaEH {

	static public String toString(VariacionDiaria variacionDiaria) {

		String toString = null;
		if (variacionDiaria != null) {
			return "VariacionDiaria [idVariacionDiaria="
					+ variacionDiaria.getIdVariacionDiaria() + ", variacion="
					+ variacionDiaria.getVariacion() + "]";
		}
		return toString;
	}

}
