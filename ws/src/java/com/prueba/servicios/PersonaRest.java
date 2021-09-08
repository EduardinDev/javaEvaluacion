package com.prueba.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.prueba.rest.entidades.Persona;
import com.prueba.rest.servicios.ServicioPersonas;

@Path("/personas")
public class PersonaRest {
	@Path("/m1")
	@GET
	public String metodo1(){
		return "Saludo desde el rest web service"; 
	}
	
	@Path("/cambiar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Persona modificar(Persona persona){
		System.out.println(persona);
		Persona perupdate = ServicioPersonas.actualizar(persona);
		return perupdate;
	}
	
}
