package com.prueba.rest.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.prueba.rest.commons.ArchivoException;
import com.prueba.rest.entidades.Persona;

public class ManejadorArchivos {
	
	private String rutaArchivo;
	
	public ManejadorArchivos(String rutaArchivo){
		this.rutaArchivo = rutaArchivo;
	}
	
	public ArrayList<Persona> leer() throws ArchivoException{
		File file = new File(rutaArchivo);	
		BufferedReader br=null;
		FileReader fileReader=null;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String linea = "";
		String[] partes;
		Persona p;
		try {
			fileReader = new FileReader(file.getAbsolutePath());
			br = new BufferedReader(fileReader);
			
			while ((linea=br.readLine())!=null) {
				partes=linea.split("-");
				p = new Persona(partes[0],partes[1],partes[2],Integer.parseInt(partes[3]));
				personas.add(p);
			}
			
			
		} catch (FileNotFoundException e) {
			//logger.error("No existe el archivo", e);
			System.out.println("No existe el archivo "+e);
			throw new ArchivoException("No existe el archivo: "+rutaArchivo);
			
		} catch (IOException e) {
			//logger.error("Error al leer el archivo", e);
			System.out.println("Error al leer el archivo "+e);
			throw new ArchivoException("Error al leer el archivo: "+rutaArchivo);
			
		} finally {
			try {
				if(br!=null){
					br.close();
				}
				
			} catch (IOException e) {
				//logger.error("Error al cerrar el BufferedReader br",e);
				System.out.println(e.getMessage());
			}
			try {
				if(fileReader!=null){
					fileReader.close();
				}
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return personas;
	}

}
