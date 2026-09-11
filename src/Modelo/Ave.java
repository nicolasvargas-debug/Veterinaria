package Modelo;

public class Ave extends Mascota {
	public boolean puedeVolar;
	
	public Ave(String codigo, String nombre, int edad, double peso, String nombrePropietario) {
		super(codigo, nombre, edad, peso, nombrePropietario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		return "Ave";
	}

	@Override
	public String emitirSonido() {
		return "Pio Pio";
	}

	@Override
	public double calcularCostoCOnsulta() {
	
		return 35000;
	}
	
}
