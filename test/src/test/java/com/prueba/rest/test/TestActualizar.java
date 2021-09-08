package com.prueba.rest.test;

import com.prueba.rest.entidades.Persona;
import com.prueba.rest.servicios.ServicioPersonas;

public class TestActualizar {

	public static void main(String[] args) {
		
		Persona persona = new Persona("1002003000","Eduardo","Olivo");
		System.out.println(ServicioPersonas.actualizar(persona));

	}

}
