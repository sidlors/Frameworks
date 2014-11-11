package com.example.entity.helper;

import com.example.entity.Categoria;

public class CategoriaEH {

	static public String toString(Categoria categoria) {
		
		String toString = null;
		if (categoria != null) {		
		toString = "Categoria [idCategoria=" + categoria.getIdCategoria()
				+ ", descripcion=" + categoria.getDescripcion() + ", nombre="
				+ categoria.getNombre() + "]";
		}
		return toString;
	}

}
