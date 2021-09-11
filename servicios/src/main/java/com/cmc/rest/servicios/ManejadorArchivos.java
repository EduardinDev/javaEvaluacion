package com.cmc.rest.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import com.cmc.rest.entidades.Persona;
import com.prueba.rest.commons.ArchivoException;
import com.prueba.rest.commons.DateUtil;

public class ManejadorArchivos {

	private String rutaArchivo;

	public ManejadorArchivos(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public ArrayList<Persona> leer() throws ArchivoException, NumberFormatException, ParseException {
		File file = new File(rutaArchivo);
		BufferedReader br = null;
		FileReader fileReader = null;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String linea = "";
		String[] partes;
		Persona p;
		try {
			fileReader = new FileReader(file.getAbsolutePath());
			br = new BufferedReader(fileReader);

			while ((linea = br.readLine()) != null) {
				partes = linea.split("-");
				p = new Persona(partes[2], partes[0], partes[1], Integer.parseInt(partes[3]),
						DateUtil.convertir(DateUtil.convertirDate(partes[4])));
				personas.add(p);
			}

		} catch (FileNotFoundException e) {
			// logger.error("No existe el archivo", e);
			System.out.println("No existe el archivo " + e);
			throw new ArchivoException("No existe el archivo: " + rutaArchivo);

		} catch (IOException e) {
			// logger.error("Error al leer el archivo", e);
			System.out.println("Error al leer el archivo " + e);
			throw new ArchivoException("Error al leer el archivo: " + rutaArchivo);

		} finally {
			try {
				if (br != null) {
					br.close();
				}

			} catch (IOException e) {
				// logger.error("Error al cerrar el BufferedReader br",e);
				System.out.println(e.getMessage());
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return personas;
	}

	public void guardarPersona(Persona persona) throws ArchivoException {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(rutaArchivo, true);
			pw = new PrintWriter(fichero);
			pw.println(persona.getNombre()+"-"+persona.getApellido()+"-"+
			persona.getCedula()+"-"+persona.getEdad()+"-"+persona.getFechaNacimiento());

		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo " + e);
			throw new ArchivoException("No existe el archivo: " + rutaArchivo);
		} catch (Exception e) {
			System.out.println("No se pudo guardar  " + e);
			throw new ArchivoException("No se pudo guardar en: " + rutaArchivo);
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

}
