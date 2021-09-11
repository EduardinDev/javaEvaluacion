package com.cmc.rest.test;

import com.cmc.rest.entidades.Persona;
import com.cmc.rest.servicios.ServicioPersonas;
import com.prueba.rest.commons.ValidationException;

public class TestActualizar {

	public static void main(String[] args) {
		
		
		Persona persona = new Persona("1002003000","Eduardo","Olivo",23,"16/06/1998");
		try {
			System.out.println(ServicioPersonas.actualizar(persona));
		} catch (ValidationException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
