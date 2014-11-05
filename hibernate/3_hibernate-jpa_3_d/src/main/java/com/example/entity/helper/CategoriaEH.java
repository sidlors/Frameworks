package com.example.entity.helper;

import com.example.entity.Categoria;

public class CategoriaEH {

	static public String toString(Categoria categoria) {
		return "Categoria [idCategoria=" + categoria.getIdCategoria()
				+ ", descripcion=" + categoria.getDescripcion() + ", nombre="
				+ categoria.getNombre() + "]";
	}

}
