package org.iesalandalus.programacion.citasclinica.modelo;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import org.iesalandalus.programacion.peonajedrez.Posicion;

public class Paciente {
	
	//1. Declaración
	
	String nombre, dni, telefono, eliminarEspacios;
	private static final String ER_TELEFONO = "^[679][0-9]{8}$";
	private final static String ER_DNI = "([0-9]{8}[a-zA-Z])|([XxYyZz][0-9]{7}[a-zA-Z])";
	
	
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
	
	public void setNombre(String dni) {
		if (nombre == null) {
			throw new IllegalArgumentException ("El nombre de un paciente no puede ser nulo.");
		}
		if(nombre.equals("")) {
			throw new IllegalArgumentException ("El nombre de un paciente no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null) {
			throw new IllegalArgumentException ("El dni de un paciente no puede ser nulo.");
		}
		if (dni.contentEquals("")) {
			throw new IllegalArgumentException ("El dni de un paciente no puede estar vacío.");
		}
		Pattern p = Pattern.compile(ER_DNI);
		Matcher m = p.matcher(dni);
		if (m.matches()) {
			this.dni = dni;
		}else {
			throw new IllegalArgumentException("El correo del paciente no es válido.");
		}
		
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws IllegalArgumentException {
		if(telefono==null) {
			this.telefono = null;
		} else {
			Pattern p = Pattern.compile(ER_TELEFONO);
			Matcher m = p.matcher(telefono);
			if(m.matches())
				this.telefono = telefono;
			else
				throw new IllegalArgumentException("El teléfono del paciente no es válido.");
		}
	}
	  
	// 5. Constructor con parámetros
	
	public Paciente (String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}
	
	// 6.Constructor copia
	
	public Paciente(Paciente e) {
		if(e == null) {
			throw new NullPointerException("ERROR: No es posible copiar un paciente nulo.");
		}
		
		setNombre(e.getNombre());
		setDni(e.getDni());
		setTelefono(e.getTelefono());
	}
	
	// 7.Métodos equals y hashCode
	
	// Método equals

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Paciente))
				return false;

			Paciente other = (Paciente) obj;

			if (other.nombre != nombre || other.dni != dni || other.telefono != telefono)
				return false;

			return true;
		}
	
	// Método hashCode
		
		@Override
		public int hashCode() {
			String letra = Validaciones.obtenerLetraDni(dni);
			char letraDni = (letra.length() > 0) ? letra.charAt(0) : 0;
			return Validaciones.obtenerDigitosDni(dni) + ((int) letraDni) * 10000000;
		}
	
	
	
	
	
	//comprobarLetraDni = 
	
			//Pattern pat = Pattern.compile("[0-9]{7,8}[A-Za-z]");
			
			//Matcher mat = pat.matcher(dni);

}
	
	
	
