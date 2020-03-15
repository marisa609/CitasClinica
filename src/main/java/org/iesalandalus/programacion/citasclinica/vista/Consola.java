package org.iesalandalus.programacion.citasclinica.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.utilidades.Comprobaciones;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	// 1. Contructor
	
		private Consola() {
		}
		
	// 2. método mostrarMenu
		
		public static void mostrarMenu() {
			System.out.println("----------------------------------------------------");
			System.out.println("                   GESTION DE CITAS                 ");
			System.out.println("----------------------------------------------------");
			System.out.println("1 - Insertar una cita");
			System.out.println("2 - Buscar una cita");
			System.out.println("3 - Borrar cita");
			System.out.println("4 - Mostrar todas las citas");
			System.out.println("5 - Mostrar todas las citas de una fecha ");
			System.out.println("----------------------------------------------------");
			System.out.println("6 - Salida del programa");
			System.out.println("----------------------------------------------------");
		}
		
	// 3. Método elegirOpcion
		
		public static Opciones elegirOpcion() {
			int opcion;
			do {
				System.out.println("¿Cuál de las opciones desea ejecutar? (1-6)");
				opcion = Entrada.entero();
			} while (opcion < 1 || opcion > 6);
			
			switch (opcion) {
			case 1:
				return Opciones.INSERTAR_CITA;
			case 2:
				return Opciones.BUSCAR_CITA;
			case 3:
				return Opciones.BORRAR_CITA;
			case 4:
				return Opciones.MOSTRAR_CITAS;
			case 5:
				return Opciones.MOSTRAR_CITAS_DIA;
			default:
				return Opciones.SALIR;
			}
		}
	
	// 4. Método leerPaciente
		
		public static Paciente leerPaciente() {
			String dni;
			String nombre;
			String telefono;
			Paciente paciente = null;
			
			System.out.println("----------------------------------------------------");
			System.out.println("                   GESTION DE CITAS                 ");
			System.out.println("----------------------------------------------------");
			System.out.println("                    DATOS PACIENTE                  ");
			System.out.println("----------------------------------------------------");
			
			System.out.println("Introduzca el DNI: ");
			dni = Entrada.cadena();

			System.out.println("Introduzca el Nombre: ");
			nombre = Entrada.cadena();

			System.out.println("Introduzca el Teléfono: ");
			telefono = Entrada.cadena();

			paciente = new Paciente(nombre, dni, telefono);

			return paciente;
		}
		
	// 5. Método leerFechaHora
			
		public static LocalDateTime leerFechaHora() {
			LocalDateTime fechaHoraFormat = null;

			String fechaHora;
			boolean success = false;

			System.out.println("----------------------------------------------------");
			System.out.println("                    GESTION DE CITAS                ");
			System.out.println("----------------------------------------------------");
			System.out.println("                    DATOS DE LA CITA                ");
			System.out.println("----------------------------------------------------");

			do {
				System.out.println("Introduzca la fecha y la hora: ");
				fechaHora = Entrada.cadena();

				try {
					fechaHoraFormat = LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern(Cita.FORMATO_FECHA_HORA));
					success = true;
				} catch (Exception ex) {
					System.out.println("La fecha introducida no es váida. Indique la fecha en un formato válido " + Cita.FORMATO_FECHA_HORA);
				}
			} while (!success);

			return fechaHoraFormat;
			}
		
	// 6. Método leerCita
		
		public static Cita leerCita() {
			Paciente paciente = leerPaciente();
			LocalDateTime fechaHora = leerFechaHora();

			return new Cita(paciente, fechaHora);
		}
	
	// 7. Método leerFecha
		
		public static LocalDate leerFecha() {
			LocalDate fechaFormat = null;

			String fecha;
			boolean success = false;

			do {
				System.out.println("Introduzca la fecha: ");
				fecha = Entrada.cadena();

				try {
					fechaFormat = LocalDate.parse(fecha, DateTimeFormatter.ofPattern(Comprobaciones.FORMATO_FECHA));
					success = true;
				} catch (Exception ex) {
					System.out.println("La fecha introducida no es válida. Indique la fecha en formato " + Comprobaciones.FORMATO_FECHA);
				}
			} while (!success);

			return fechaFormat;
		}
}
