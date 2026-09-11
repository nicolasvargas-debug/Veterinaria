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
        
        
        
    }

}
