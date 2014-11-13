package com.example.as;

import java.util.List;

import com.example.entity.Jugador;

public interface AdminJugadoresAS {

	public void persist(Jugador jugador) throws Exception;
	public void remove(Jugador jugador) throws Exception;
	public void merge(Jugador jugador) throws Exception;
	public Jugador findByIdJugadores(int id) throws Exception;
	public List<Jugador> findAllJugadores() throws Exception;
	
}
