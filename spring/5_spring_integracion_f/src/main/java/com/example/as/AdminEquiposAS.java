package com.example.as;

import java.util.List;

import com.example.entity.Equipo;

public interface AdminEquiposAS {

	public void persist(Equipo equipo) throws Exception;
	public void remove(Equipo equipo) throws Exception;
	public void merge(Equipo equipo) throws Exception;
	public Equipo findByIdEquipoSinJugadores(int id) throws Exception;
	public List<Equipo> findAllEquipoSinJugadores() throws Exception;
	
}
