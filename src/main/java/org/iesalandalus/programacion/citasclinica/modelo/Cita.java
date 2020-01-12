package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;

public class Cita {
	
	// 1. Atributos
	
	public final static String FORMATO_FECHA_HORA = "dd/MM/yyyy hh:mm"; 
	private LocalDateTime fechaHora;
	private Paciente paciente;
	
	
	// 2. Métodos get y set
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		if (fechaHora==null) {
			throw new NullPointerException("ERROR: La fecha y hora de una cita no puede ser nula.");
		}
		this.fechaHora = fechaHora;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		if (paciente==null) {
			throw new NullPointerException("ERROR: El paciente de una cita no puede ser nulo.");
		}
		this.paciente = paciente;
	}
	
	// 3. Contructor con parámetros
	
	public Cita (Paciente paciente, LocalDateTime fechaHora) {
		setPaciente(paciente);
		setFechaHora(fechaHora);
	}
	
	// 4. Contructor copia
	
	
}
