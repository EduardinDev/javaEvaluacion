package com.prueba.rest.test;

import com.prueba.rest.commons.ValidationException;
import com.prueba.rest.entidades.Persona;
import com.prueba.rest.servicios.ServicioPersonas;

public class TestActualizar {

	public static void main(String[] args) {
		
		
		Persona persona = new Persona("1002003000","Eduardo","Olivo",23);
		try {
			System.out.println(ServicioPersonas.actualizar(persona));
		} catch (ValidationException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
