package com.prueba.rest.entidades;

public class Consulta {

	private String cedula;
	
	public Consulta() {
		
	}

	public Consulta(String cedula) {
		super();
		this.cedula = cedula;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	@Override
	public String toString() {
		return "Consulta [cedula=" + cedula + "]";
	}
	
	
}
