package com.example.entity.helper;

import com.example.entity.DetalleAccion;

public class DetalleAccionEH {

	static public String toString(DetalleAccion detalleAccion) {

		String toString = null;
		if (detalleAccion != null) {
			toString = "DetalleAccion [idDetalleAccion="
					+ detalleAccion.getIdDetalleAccion()
					+ ", descripcionCompania="
					+ detalleAccion.getDescripcionCompania()
					+ ", fechaRevision=" + detalleAccion.getFechaRevision()
					+ ", nombreCompania=" + detalleAccion.getNombreCompania()
					+ "]";
		}
		return toString;
	}

}
