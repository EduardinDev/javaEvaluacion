package com.prueba.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.prueba.rest.commons.ArchivoException;
import com.prueba.rest.commons.ValidationException;
import com.prueba.rest.entidades.Persona;
import com.prueba.rest.servicios.ManejadorArchivos;
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
	public Object modificar(Persona persona){
		Persona per = new Persona();
		System.out.println(persona);
		Persona perupdate;
		try {
			perupdate = ServicioPersonas.actualizar(persona);
		} catch (ValidationException e) {
			//e.printStackTrace();
			return e.getMessage();
		}
		return perupdate;
	}
	
	
	
	@Path("/cambio")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static Response cambiar(Persona persona){
		System.out.println(persona);
		try {
			ServicioPersonas.actualizar(persona);
		} catch (ValidationException e) {
			return Response.status(200).entity(e.getMessage()).build();
		}
		return Response.status(200).entity(persona).build();
	}
	
	
	
	@Path("/consultarPersonas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPersonas(){
		ManejadorArchivos ma = new ManejadorArchivos("personas.txt");
		try {
			ArrayList<Persona> personas=ma.leer();
			return Response.status(200).entity(personas).build();
			//System.out.println(personas);
		} catch (ArchivoException e) {
			//logger.error("No existe el archivo ", e);
			return Response.status(200).entity(e.getMessage()).build();
		}catch (Exception ex) {
			//logger.error("El sistema está dormido ", ex);
			return Response.status(200).entity(ex.getMessage()).build();
		}
	}
}
