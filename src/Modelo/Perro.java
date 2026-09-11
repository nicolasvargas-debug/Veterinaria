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
		// TODO Auto-generated method stub //Falta por hacer 
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
