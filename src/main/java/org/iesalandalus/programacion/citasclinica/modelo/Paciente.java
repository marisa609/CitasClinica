package org.iesalandalus.programacion.citasclinica.modelo;

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

}
