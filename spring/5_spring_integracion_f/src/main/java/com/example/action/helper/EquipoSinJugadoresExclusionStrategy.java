package com.example.action.helper;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class EquipoSinJugadoresExclusionStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes arg0) {
		// TODO Auto-generated method stub
		if (arg0.getName().equalsIgnoreCase("jugadores")) {
			return true;
		}		
		return false;
	}

}
