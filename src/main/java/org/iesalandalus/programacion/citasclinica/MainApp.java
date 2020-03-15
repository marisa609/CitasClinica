package org.iesalandalus.programacion.citasclinica;

import java.time.LocalDateTime;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.vista.Consola;

public class MainApp {

	public static void main(String[] args) {
		
	// 1. Atributos
		
		public final static int NUM_MAX_CITAS = 10;
		private static Citas citasClinica = new Citas(NUM_MAX_CITAS);
		
	// 2. Método insertarCita
		
		private static void insertarCita() {
		
			Cita cita =null;
			
			try
			{
				cita=Consola.leerCita();
				citasClinica.insertar(cita);
			}
			catch(Exception ex)
			{
				System.out.println("Se ha producido el siguiente error: " + ex.getMessage());
			}
		}
		
	// 3. Método buscarCita
		
		public static void buscarCita() {

			try
			{
				LocalDateTime fechaHora= Consola.leerFechaHora();
				Cita cita = new Cita()
				citasClinica.buscar(cita)(fechaHora);
			}
			catch(Exception ex)
			{
				System.out.println("Se ha producido el siguiente error: " + ex.getMessage());
			}
		}
		
	// 4. Método borrar cita
		
		public void borrarAula() {
			Consola.mostrarCabecera("BORRAR AULA");
			try {
				modelo.borrarAula(new Aula(Consola.leerNombreAula()));
				System.out.println("Aula eliminada.");
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(ERROR + e.getMessage());
			}
		}
		
	}
	
}
