package com.prueba.rest.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String convertir(){
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formateadorFecha.format(new Date());
	}
}
