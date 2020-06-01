package org.iesalandalus.programacion.citasclinica.modelo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Citas {

	// 1. Atributos

	int capacidad, tamano;
	private Cita[] coleccionCitas;

	// 2. Método set sin parámetros

	public int getTamano() {
		return tamano;
	}

	public int getCapacidad() {
		return capacidad;
	}

	// 3. Métodos capacidadSuperada y tamanoSuperado

	private boolean tamanoSuperado(int tamanoActual) {
		return tamanoActual >= getTamano();
	}

	private boolean capacidadSuperada(int numCitas) {
		return numCitas >= capacidad;
	}

	// Contructores

	public Citas(int capacidad) {
		if (capacidad <= 0) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		coleccionCitas = new Cita[capacidad];
		this.capacidad = capacidad;
		tamano = 0;
	}

	// 4. Método buscarIndice

	private int buscarIndice(Cita cita) {

		if (cita == null) {
			throw new NullPointerException("ERROR: No se puede copiar una cita nula.");
		}

		int indice = 0;
		boolean citaEncontrada = false;

		while (!tamanoSuperado(indice) && !citaEncontrada) {
			if (coleccionCitas[indice].equals(cita)) {
				citaEncontrada = true;
			} else {
				indice++;
			}
		}
		return indice;

	}

	/*
	 * private int buscarIndice(Cita cita) { if (cita == null) { throw new
	 * NullPointerException("ERROR: No se puede copiar una cita nula."); }
	 * 
	 * int indiceCitaEncontrada = -1;
	 * 
	 * for (int i = 0; i < coleccionCitas.length && coleccionCitas[i] != null &&
	 * indiceCitaEncontrada < 0; i++) { if (coleccionCitas[i].getFechaHora() ==
	 * cita.getFechaHora()) { indiceCitaEncontrada = i; } }
	 * 
	 * return (indiceCitaEncontrada >= 0) ? indiceCitaEncontrada : getTamano() + 1;
	 * }
	 */

	// 5. Método insertar

	public void insertar(Cita cita) throws OperationNotSupportedException {
		if (cita == null) {
			throw new NullPointerException("ERROR: No se puede insertar una cita nula.");
		}

		int indice = buscarIndice(cita);

		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más citas.");
		}

		if (buscar(cita) != null) {
			throw new OperationNotSupportedException("ERROR: Ya existe una cita para esa fecha y hora.");
		}

		coleccionCitas[getTamano()] = new Cita(cita);
		tamano++;
	}

	// 6. Método buscar

	public Cita buscar(Cita cita) {
		if (cita == null) {
			throw new NullPointerException("ERROR: No se puede copiar una cita nula.");
		}

		Cita citaEncontrada = null;

		for (int i = 0; i < coleccionCitas.length && coleccionCitas[i] != null && citaEncontrada == null; i++) {
			if (coleccionCitas[i].getFechaHora().isEqual(cita.getFechaHora())) {
				citaEncontrada = coleccionCitas[i];
			}
		}

		return citaEncontrada;
	}

	// 7. Método desplazarUnaPosicionHaciaIzquierda

	private void desplazarUnaPosicionHaciaIzquierda(int indiceCita) throws IllegalArgumentException {
		if (indiceCita < 0 || indiceCita >= getCapacidad()) {
			throw new IllegalArgumentException("El índice de la cita debe estar comprendido en el intervalo correcto");
		}

		if (indiceCita < getCapacidad() - 1) {
			for (int i = indiceCita; i < getCapacidad() - 1; i++) {
				coleccionCitas[i] = coleccionCitas[i + 1];
			}
		}

		coleccionCitas[getCapacidad() - 1] = null;
	}

	// 8. Método borrar

	public void borrar(Cita cita) throws OperationNotSupportedException {
		if (cita == null) {
			throw new IllegalArgumentException("ERROR: No se puede borrar una cita nula.");
		}

		int indice = buscarIndice(cita);

		if (!tamanoSuperado(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ninguna cita para esa fecha y hora.");
		}

		tamano--;

	}

	// 9. Método getCitas

	public Cita[] getCitas() {
		return coleccionCitas;
	}

	public Cita[] getCitas(LocalDate fecha) {
		if (fecha == null) {
			throw new NullPointerException("ERROR: No se pueden devolver las citas para un día nulo.");
		}

		Cita[] citasEncontradas = new Cita[getCapacidad()];
		int posCita = 0;

		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionCitas[i].getFechaHora().toLocalDate().equals(fecha)) {
				citasEncontradas[posCita++] = coleccionCitas[i];
			}
		}

		return citasEncontradas;
	}
}
