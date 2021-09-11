package com.prueba.rest.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private final static SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");

	public static String convertir(){
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formateadorFecha.format(new Date());
	}
	
	
	public static String convertir(Date fecha){
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("MM/dd/yyyy");
		return formateadorFecha.format(fecha);
	}
	
	public static Date convertirDate(String fechaNacimiento) throws ParseException{
		Date fechaUpdate = FORMATO.parse(fechaNacimiento);
		return fechaUpdate;
	}
}
