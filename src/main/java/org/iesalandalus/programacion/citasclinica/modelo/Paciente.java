package org.iesalandalus.programacion.citasclinica.modelo;

import java.util.Objects;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import org.iesalandalus.programacion.utilidades.Comprobaciones;

public class Paciente {

	// 1. Declaración

	String nombre, dni, telefono, eliminarEspacios;
	private static final String ER_NOMBRE = "[A-Za-záéíóúÁÉÍÓÚ]+(\\s+[A-Za-záéíóúÁÉÍÓÚ]+)+";
	private static final String ER_TELEFONO = "^[679][0-9]{8}$";
	private final static String ER_DNI = "([0-9]{8})([a-zA-Z])";

	// 2. Creo el método formateaNombre

	private String formateaNombre(String nombreObjeto) {
		if (nombreObjeto == null || nombreObjeto.trim().length() == 0) {
			throw new NullPointerException("ERROR: El nombre de un paciente no puede ser nulo.");
		}

		nombreObjeto = nombreObjeto.replace("  ", " ");

		String[] words = nombreObjeto.split("\\s+");

		if (words.length == 0) {
			throw new NullPointerException("ERROR: El nombre de un paciente no puede ser nulo.");
		}

		StringBuilder nombreFormateado = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			String word = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
			nombreFormateado.append(word).append(" ");
		}

		return nombreFormateado.toString().trim();
	}

	// 3. Creo el método comprobarLetraDni

	private boolean comprobarLetraDni(String dni) {
		return Comprobaciones.dniValido(dni);
	}

	// 4. Creo los métodos get y set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre de un paciente no puede ser nulo o vacío.");
		}
		if (nombre.trim().equals("")) {
			throw new IllegalArgumentException("El nombre de un paciente no puede estar vacío.");
		}
		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}
		this.nombre = formateaNombre(nombre);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI de un paciente no puede ser nulo o vacío.");
		}
		if (dni.contentEquals("")) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (comprobarLetraDni(dni)) {
			this.dni = dni;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) throws IllegalArgumentException {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono de un paciente no puede ser nulo o vacío.");
		}
		if (telefono.contentEquals("")) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}
		this.telefono = telefono;
	}

	// 5. Constructor con parámetros

	public Paciente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	// 6.Constructor copia

	public Paciente(Paciente paciente) {
		if (paciente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un paciente nulo.");
		}

		setNombre(paciente.getNombre());
		setDni(paciente.getDni());
		setTelefono(paciente.getTelefono());
	}

	// 7.Métodos equals y hashCode

	// Método equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	// Método hashCode

	public int hashCode() {
		return Objects.hash(nombre, dni, telefono);
	}

	// 8. Método getIniciales

	private String getIniciales() {

		StringBuilder stb = new StringBuilder();

		Pattern p = Pattern.compile("([A-Z]*)");
		Matcher m = p.matcher(nombre);

		while (m.find()) {
			String inicial = m.group(1);
			stb.append(inicial);
		}

		return stb.toString();

	}

	// 9. Método toString

	@Override
	public String toString() {
		return "nombre=" + nombre + " (" + getIniciales() + ")," + " DNI=" + dni + ", teléfono=" + telefono;
	}

}
