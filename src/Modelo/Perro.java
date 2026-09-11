package Modelo;

public class Perro extends Mascota implements Vacunable, Peluqueable {
	private String raza;
	private String tamaño;
	private boolean vacunado;	
	
	public Perro(String codigo, String nombre, int edad, double peso, String nombrePropietario) {
		super(codigo, nombre, edad, peso, nombrePropietario);
		
	}

	@Override
	public void vacunar() {
		if (vacunado) {
			throw new IllegalArgumentException(getNombre() + "Ya esta vacuando");
		}
		else {
			vacunado = true;
		}
	}

	@Override
	public boolean estaVacunado() {
		return vacunado;
	}

	@Override
	public double calcularCostoPeluqueria() {
		if (tamaño.equalsIgnoreCase("pequeño")) {
			return 30000;
		}
		else if(tamaño.equalsIgnoreCase("mediano")) {
			return 40000;
		}
		else if(tamaño.equalsIgnoreCase("grande")) {
			return 55000;
		}
		return -1;
	}

	@Override
	public String getTipo() {
		return "Perro";
	}

	@Override
	public String emitirSonido() {
		return "Guau";
	}

	@Override
	public double calcularCostoCOnsulta() {
		if (tamaño.equalsIgnoreCase("pequeño")){
			return 40000;
		}
		else if (tamaño.equalsIgnoreCase("mediano")){
			return 40000;
		}
		else if (tamaño.equalsIgnoreCase("grande")){
			return 40000;
		}
		return -1;
	}
	
	
	
}
