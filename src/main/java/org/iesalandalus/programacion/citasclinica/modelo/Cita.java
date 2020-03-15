package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita {

	// 1. Atributos

	public final static String FORMATO_FECHA_HORA = "dd/MM/yyyy hh:mm";
	private LocalDateTime fechaHora;
	private Paciente paciente;

	// 2. Métodos get y set

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	private void setFechaHora(LocalDateTime fechaHora) {
		if (fechaHora == null) {
			throw new NullPointerException("ERROR: La fecha y hora de una cita no puede ser nula.");
		}
		this.fechaHora = fechaHora;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		if (paciente == null) {
			throw new NullPointerException("ERROR: El paciente de una cita no puede ser nulo.");
		}
		this.paciente = new Paciente(paciente);
	}

	// 3. Contructor con parámetros

	public Cita(Paciente paciente, LocalDateTime fechaHora) {
		setPaciente(paciente);
		setFechaHora(fechaHora);
	}

	// 4. Contructor copia

	public Cita(Cita cita) {
		if (cita == null) {
			throw new NullPointerException("ERROR: No se puede copiar una cita nula.");
		}
		setPaciente(cita.getPaciente());
		setFechaHora(cita.getFechaHora());
	}

	// 5. Métodos equals y hashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		return true;
	}

	// Método toString

	@Override
	public String toString() {
		return String.format("%s, fechaHora=%s", paciente.toString(),
				fechaHora.format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA)));
	}

}
