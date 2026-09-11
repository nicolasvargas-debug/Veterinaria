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
				System.out.println("Ingrese el Nombre de la clinica veterinaria:");
				nombreClinica = sc.nextLine();
				clinica = new ClinicaVeterinaria(nombreClinica);
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
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
							registrarMascotaMenu(nombreClinica); 
							break;
						}
					case 2:
					{
						listarMascotas();
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
				System.out.println("Error: Debe ingresar un valor numérico válido.");
			}
			catch (IllegalArgumentException | IllegalStateException e) {
				System.out.println("Operación rechazada: " + e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Ocurrió un error inesperado: " + e.getMessage());
			}
		} while (opcion != 0);
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
	
	private static void registrarMascotaMenu(String nombre) {
        System.out.println("\n--- REGISTRAR MASCOTA ---");
        System.out.println("Tipo de mascota: 1. Perro | 2. Gato | 3. Ave");
        System.out.print("Seleccionar Tipo: ");
        int tipo = Integer.parseInt(sc.nextLine().trim());

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de mascota no válido.");
            return;
        }

        System.out.print("Ingrese el código: ");
        String codigo = sc.nextLine();

        if (clinica.buscarMascota(codigo) != null) {
            System.out.println("Error: Ya existe una mascota registrada con el código " + codigo);
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombreMascota = sc.nextLine();
        
        System.out.print("Ingrese la edad (años): ");
        int edad = Integer.parseInt(sc.nextLine().trim());
        
        System.out.print("Ingrese el peso (kg): ");
        double peso = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
        
        System.out.print("Ingrese el nombre del propietario: ");
        String propietario = sc.nextLine();

        Mascota nuevaMascota = null;

        if (tipo == 1) {
            nuevaMascota = new Perro(codigo, nombreMascota, edad, peso, propietario);
        } else if (tipo == 2) {
            nuevaMascota = new Gato(codigo, nombreMascota, edad, peso, propietario);
        } else if (tipo == 3) {
            System.out.print("¿Puede volar? (S/N): ");
            boolean vuela = sc.nextLine().trim().equalsIgnoreCase("S");
            	
            Ave ave = new Ave(codigo, nombreMascota, edad, peso, propietario);
            ave.puedeVolar = vuela;
            
            nuevaMascota = ave;
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
	
	private static void listarMascotas() {
        System.out.println("\n--- LISTA DE MASCOTAS ---");
        if (clinica.getMascotas().isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        for (Mascota m : clinica.getMascotas()) {
            System.out.println("Código: " + m.getCodigo() + " | Nombre: " + m.getNombre() +  " | Tipo: " + m.getTipo() +" | Propietario: " + m.getNombrePropietario());
        }
    }
	
	private static void buscarMascotaMenu(String nombre) {
        System.out.println("\n--- BÚSQUEDA DE MASCOTAS EN " + nombre + " ---");
        System.out.print("Ingrese el código de la mascota a buscar: ");
        String codigo = sc.nextLine();
        Mascota m = clinica.buscarMascota(codigo);

        if (m != null) {
            System.out.println("Mascota encontrada: " + m.getNombre() + " | Tipo: " + m.getTipo());
        } else {
            System.out.println("No se encontró ninguna mascota con ese código.");
        }
    }
	private static void actualizarDatosMascota() {
        System.out.print("\nIngrese el código de la mascota a actualizar: ");
        String codigo = sc.nextLine();
        Mascota m = clinica.buscarMascota(codigo);

        if (m != null) {
            System.out.println("Actualizando datos de " + m.getNombre() + " (Deje en blanco para no modificar)");
            
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.trim().isEmpty()) m.setNombre(nuevoNombre);
            
            System.out.print("Nueva edad (Deje en blanco o -1 para saltar): ");
            String nuevaEdad = sc.nextLine();
            if (!nuevaEdad.trim().isEmpty() && !nuevaEdad.equals("-1")) {
                m.setEdad(Integer.parseInt(nuevaEdad.trim()));
            }
            
            System.out.print("Nuevo peso (Deje en blanco o -1 para saltar): ");
            String nuevoPeso = sc.nextLine();
            if (!nuevoPeso.trim().isEmpty() && !nuevoPeso.equals("-1")) {
                m.setPeso(Double.parseDouble(nuevoPeso.trim().replace(',', '.')));
            }
            
            System.out.print("Nuevo propietario: ");
            String nuevoPropietario = sc.nextLine();
            if (!nuevoPropietario.trim().isEmpty()) m.setNombrePropietario(nuevoPropietario);
            
            System.out.println("Datos actualizados correctamente.");
        } else {
            System.out.println("Mascota no encontrada.");
        }
    }
	
	private static void vacunarMascotaMenu() {
        System.out.print("\nIngrese el código de la mascota a vacunar: ");
        String codigo = sc.nextLine();
        Mascota m = clinica.buscarMascota(codigo);

        if (m != null) {
            if (m instanceof Vacunable) {
                Vacunable v = (Vacunable) m;
                if (v.estaVacunado()) {
                    System.out.println("La mascota " + m.getNombre() + " ya se encuentra vacunada.");
                } else {
                    v.vacunar();
                    System.out.println("¡" + m.getNombre() + " ha sido vacunada exitosamente!");
                }
            } else {
                System.out.println("Este tipo de mascota no tiene la capacidad de ser vacunada.");
            }
        } else {
            System.out.println("Mascota no encontrada.");
        }
    }
	
	private static void cotizarPeluqueriaMenu() {
        System.out.print("\nIngrese el código de la mascota para cotizar peluquería: ");
        String codigo = sc.nextLine();
        Mascota m = clinica.buscarMascota(codigo);

        if (m != null) {
            if (m instanceof Peluqueable) {
                double costo = ((Peluqueable) m).calcularCostoPeluqueria();
                System.out.println("El costo del servicio de peluquería para " + m.getNombre() + " es: $" + costo);
            } else {
                System.out.println("Este tipo de mascota no recibe servicio de peluquería.");
            }
        } else {
            System.out.println("Mascota no encontrada.");
        }
    }
	private static void atenderMascota() {
        System.out.print("\nIngrese el código de la mascota a atender: ");
        String codigo = sc.nextLine();
        Mascota m = clinica.buscarMascota(codigo);

        if (m != null) {
            System.out.println("\n--- ATENDIENDO CONSULTA ---");
            System.out.println("Paciente: " + m.getNombre());
            System.out.println("Tipo: " + m.getTipo());
            System.out.println("Sonido de la mascota: " + m.emitirSonido());
            System.out.println("Valor de la consulta: $" + m.calcularCostoCOnsulta());
        } else {
            System.out.println("Mascota no encontrada.");
        }
    }
	
	private static void eliminarMascota() {
        System.out.print("\nIngrese el código de la mascota a eliminar: ");
        String codigo = sc.nextLine();
        boolean eliminado = clinica.eliminarMascota(codigo);

        if (eliminado) {
            System.out.println("La mascota fue eliminada correctamente del sistema.");
        } else {
            System.out.println("No se encontró ninguna mascota con el código proporcionado.");
        }
    }
	
	private static void consultarTotalConsultas() {
        double total = clinica.calcularValorTotal();
        System.out.println("\nEl valor total proyectado de consultas para todas las mascotas registradas es: $" + total);
    }
	

}
