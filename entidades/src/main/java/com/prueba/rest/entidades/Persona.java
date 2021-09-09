package com.prueba.rest.entidades;

import java.util.Date;

import com.prueba.rest.commons.DateUtil;

public class Persona {

	private String cedula;
	private String nombre;
	private String apellido;
	private int edad;
	private String fechaCreacion=DateUtil.convertir().toString(); //necesario para que se ejecute en el servidor
	
	public Persona() {
		
	}

	public Persona(String cedula, String nombre, String apellido, int edad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaCreacion = DateUtil.convertir().toString();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	



	
	
	
}
