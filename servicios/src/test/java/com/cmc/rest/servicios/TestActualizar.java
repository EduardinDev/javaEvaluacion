package com.cmc.rest.servicios;

import com.cmc.rest.entidades.Persona;

public class TestActualizar {

	public static void main(String[] args) {
		
		Persona persona = new Persona("1002003000","Eduardo","Olivo");
		System.out.println(ServicioPersonas.actualizar(persona));

	}

}
