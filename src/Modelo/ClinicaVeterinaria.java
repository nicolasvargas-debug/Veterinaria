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
	public double calcularValorTotal() {
		double valorTotal = 0;
		for (Mascota m : mascotas) {
			valorTotal += m.calcularCostoCOnsulta();
		}
		return valorTotal;
		
	}
	
	public boolean registrarMascota(Mascota m) {
		if (buscarMascota(m.getCodigo()) != null ) {
			mascotas.add(m);
			return true;
		}
		else {
			return false;
		}
	}
}
