package org.iesalandalus.programacion.citasclinica.modelo;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Paciente {
	
	//Declaración
	
	String nombre, dni, telefono, eliminarEspacios;
	
	
	// Creo el método formateaNombre
	
	public void formateaNombre() {
		for (int x=0; x < nombre.length(); x++) {
			  if (nombre.charAt(x) != ' ')
			    eliminarEspacios += nombre.charAt(x);
			}
		String primeraLetra = nombre.substring(0, 1).toUpperCase();

		String restoDeLaCadena = nombre.substring(1).toLowerCase();
		
		String restoMinuscula = primeraLetra + restoDeLaCadena;
		
		restoMinuscula = nombre;
		
		return;
	}
	
	public void comprobarLetraDni () {
		
		String numerosDni = dni.substring(0, dni.length()-1);
		  
		String letras = dni.substring(dni.length()-1);
	 	
		int conversionNumerosDni = Integer.parseInt (numerosDni);
		int dividiendo = 23;
		int restoDivision = conversionNumerosDni % dividiendo;
		
		if (restoDivision = 0) 
				letras = T;
		
			
			
		
		
		//comprobarLetraDni = 
		
		//Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
		
		//Matcher mat = pat.matcher(dni);
	}
	                                  

}
