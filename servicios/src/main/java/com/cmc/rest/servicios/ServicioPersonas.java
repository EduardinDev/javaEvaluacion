package com.cmc.rest.servicios;

import java.text.ParseException;
import java.util.ArrayList;

import com.cmc.rest.entidades.Persona;
import com.prueba.rest.commons.ArchivoException;
import com.prueba.rest.commons.ValidationException;

public class ServicioPersonas {

	public static Persona actualizar(Persona persona) throws ValidationException {

		if (persona.getNombre().length() > 3) {
			if (persona.getApellido().length() > 3) {
				
				String nombreUpdate = persona.getNombre().toUpperCase();
				String apellidoUpdate = persona.getApellido().toUpperCase();

				persona.setNombre(nombreUpdate);
				persona.setApellido(apellidoUpdate);

				return persona;
				
			} else {
				throw new ValidationException("El apellido es muy corto");
			}
		} else {
			throw new ValidationException("El nombre es muy corto");
		}

	}
	
	
	public static Persona buscarPorCedula(String cedula) throws ArchivoException, NumberFormatException, ParseException{
		ManejadorArchivos manejador = new ManejadorArchivos("personas.txt");
		ArrayList<Persona> personas = manejador.leer();
		
		for(Persona persona:personas){
			if(persona.getCedula().equals(cedula)){
				return persona;
			}
		}
		return null;
	}

}
