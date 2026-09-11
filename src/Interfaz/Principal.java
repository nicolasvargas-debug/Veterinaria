package Interfaz;

import java.util.ArrayList;
import java.util.Scanner;
import Modelo.*;

public class Principal {
	
	private static ClinicaVeterinaria clinica;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Bienvenidos");
		String nombreClinica = "";
		while(clinica == null) {
			try {
			System.out.println("Ingrese el Nombre de la clinica veterinaria");
			nombreClinica = sc.nextLine();
			clinica = new ClinicaVeterinaria(nombreClinica);
			} catch (IllegalArgumentException e) {
				System.out.println("Error " + e.getMessage());
			}
		}
		int opcion = -1;
		do {
			mostrarMenu(nombreClinica);
			try {
				
				opcion = Integer.parseInt(sc.nextLine().trim());
				
				switch(opcion) {
				
					case 1:
						{
						registrarMascotaMenu();
						break;
						}
					case 2:
					{
						ListarMascotas();
						break;
					}
					case 3:
					{
						buscarMascotaMenu(nombreClinica);
						break;
					}
					case 4:
					{
						actualizarDatosMascota();
						break;
					}
					case 5:
					{
						vacunarMascotaMenu();
						break;
					}
					case 6:
					{
						cotizarPeluqueriaMenu();
						break;
					}
					case 7:
					{
						atenderMascota();
						break;
					}
					case 8:
					{
						eliminarMascota();
						break;
					}
					case 9:
					{
						consultarTotalConsultas();
						break;
					}
					case 0:
					{
						System.out.println("Gracias por usar la el sistema de veterinatia");
						break;
					}
					default:
						System.out.println("Opción no válida. Ingrese un número entre 0 y 9.");
				}
				}
				catch (NumberFormatException e) {
					System.out.println("Error, debe ingresar un numero entero");
				}
				catch (IllegalArgumentException | IllegalStateException e) {
					System.out.println("Error en la validacion del dominio " + e.getMessage());
				}
				catch (Exception e) {
					System.out.println("Ocurrio un error inesperado " + e.getMessage());
				}
			}while (opcion != 0);
		
		
	}
	
	private static void mostrarMenu(String nombre) {
		
        System.out.println("============== MENÚ (" + nombre + ") ==============");
        System.out.println("1. Registrar una mascota");
        System.out.println("2. Listar todas las mascotas");
        System.out.println("3. Buscar una mascota");
        System.out.println("4. Actualizar datos de una mascota");
        System.out.println("5. Vacunar una mascota");
        System.out.println("6. Cotizar servicio de peluquería");
        System.out.println("7. Atender consulta veterinaria");
        System.out.println("8. Eliminar una mascota");
        System.out.println("9. Calcular valor de todas las consultas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
	
	private static void registrarMascotaMenu(String nombre ) {
		
        System.out.println("============== MENÚ (" + nombre  + ") ==============");
        System.out.println("Registrar una mascota");
        System.out.println("Tipo de mascota: 1. Perro | 2. Gato | 3. Ave");
        System.out.println("Seleccionar Tipo:");
        int Tipo = Integer.parseInt(sc.nextLine().trim());
        
        if (Tipo < 1 || Tipo > 3 ) {
        	System.out.println("Tipo de mascota NO valido");
        	return;
        	}
        System.out.println("Ingrese el codigo:");
		String codigo = sc.nextLine();
		System.out.println("Ingrese el nombre:");
		String nombreMascota = sc.nextLine();
		
		System.out.println("Ingrese la edad (años):");
		int edad = Integer.parseInt(sc.nextLine().trim());
		
		System.out.println("Ingrese el peso (kg):");
		double peso = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
		
		System.out.println("Ingrese el nombre del propietario:");
		String propietario = sc.nextLine();
		
		Mascota nuevaMascota = null;
		
		if (Tipo == 1) {
			nuevaMascota = new Perro(codigo, nombreMascota, edad, peso, propietario);
		} else if (Tipo == 2) {
			nuevaMascota = new Gato(codigo, nombreMascota, edad, peso, propietario);
		} else if (Tipo == 3) {
			System.out.println("xd");
			return;
		}
		if (nuevaMascota != null) {
			boolean exito = clinica.registrarMascota(nuevaMascota);
			if (exito) {
				System.out.println("¡Mascota registrada exitosamente!");
			} else {
				System.out.println("No se pudo registrar la mascota.");
			}
		}
	}
	
	private static void ListarMascotas() {
		System.out.println("--- LISTA DE MASCOTAS ---");
		if (clinica.getMascotas().isEmpty()) {
			System.out.println("No hay mascotas registradas.");
			return;
		}
		for (Mascota m : clinica.getMascotas()) {
			System.out.println("Código: " + m.getCodigo() + " | Nombre: " + m.getNombre() + " | Propietario: " + m.getNombrePropietario());
		}
	}
	
	private static void buscarMascotaMenu(String nombre) {
		System.out.println("--- BÚSQUEDA DE MASCOTAS EN " + nombre + " ---");
		System.out.print("Ingrese el código de la mascota a buscar: ");
		String codigo = sc.nextLine();
		Mascota m = clinica.buscarMascota(codigo);
		
		if (m != null) {
			System.out.println("Mascota encontrada: " + m.getNombre() + " | Tipo: " + m.getTipo());
		} else {
			System.out.println("No se encontró ninguna mascota con ese código.");
		}
	}
	

}
