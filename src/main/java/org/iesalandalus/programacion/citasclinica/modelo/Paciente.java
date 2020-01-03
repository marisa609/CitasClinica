package org.iesalandalus.programacion.citasclinica.modelo;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Paciente {
	
	//1. Declaración
	
	String nombre, dni, telefono, eliminarEspacios;
	
	
	//2. Creo el método formateaNombre
	
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
	
	//3. Creo el método comprobarLetraDni
	
	public String comprobarLetraDni () {
		
		String numerosDni = dni.substring(0, dni.length()-1);
		  
		String letras = dni.substring(dni.length()-1);
	 	
		int conversionNumerosDni = Integer.parseInt (numerosDni);
		int dividiendo = 23;
		int restoDivision = conversionNumerosDni % dividiendo;
		
		char [] letras1 = new char [23];
		
		letras1 [0] = 'T';
		letras1 [1] = 'R';
		letras1 [2] = 'W';
		letras1 [3] = 'A';
		letras1 [4] = 'G';
		letras1 [5] = 'M';
		letras1 [6] = 'Y';
		letras1 [7] = 'F';
		letras1 [8] = 'P';
		letras1 [9] = 'D';
		letras1 [10] = 'X';
		letras1 [11] = 'B';
		letras1 [12] = 'N';
		letras1 [13] = 'J';
		letras1 [14] = 'Z';
		letras1 [15] = 'S';
		letras1 [16] = 'Q';
		letras1 [17] = 'V';
		letras1 [18] = 'H';
		letras1 [19] = 'L';
		letras1 [20] = 'C';
		letras1 [21] = 'K';
		letras1 [22] = 'E';
	}
		
	//4. Creo los métodos get y set 
		

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
			if (nombre =! ) {
				throw new IllegalArgumentException("ERROR: ");
			}
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		
		this.telefono = telefono;
	}
	  
	
	
	
	
	
	//comprobarLetraDni = 
	
			//Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
			
			//Matcher mat = pat.matcher(dni);

}
	
	
	
