package Modelo;
import java.util.ArrayList;

public class ClinicaVeterinaria {
	private String nombre;
	private ArrayList<Mascota> mascotas;
	
	public ClinicaVeterinaria(String nombre) {
		this.nombre =  nombre;
		this.mascotas =  new ArrayList<Mascota>();
	}
	
	public Mascota buscarMascota( String codigo) {
		for (Mascota m : mascotas  ) {
			if (m.getCodigo() == codigo) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Mascota> getMascotas(){
		return mascotas;
	}
	
	public boolean eliminarMascota(String codigo){
		if (buscarMascota(codigo) != null ) {
			mascotas.remove(buscarMascota(codigo));
		}
		return false;
	}
	//public double calcularValorTotal() {}
}
