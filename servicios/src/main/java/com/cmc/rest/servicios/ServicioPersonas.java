package com.cmc.rest.servicios;

import com.cmc.rest.entidades.Persona;

public class ServicioPersonas {

	public static Persona actualizar(Persona persona){
		String nombreUpdate = persona.getNombre().toUpperCase();
		String apellidoUpdate = persona.getApellido().toUpperCase();
		
		persona.setNombre(nombreUpdate);
		persona.setApellido(apellidoUpdate);
		
		return persona;
		
	}
	
}
