package Modelo;

public class Gato extends Mascota implements Vacunable, Peluqueable{
	private String color;
	private boolean vacunado;
	
	public Gato(String codigo, String nombre, int edad, double peso, String nombrePropietario) {
		super(codigo, nombre, edad, peso, nombrePropietario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		return "gato";
	}

	@Override
	public String emitirSonido() {
		return "Miau";
	}

	@Override
	public double calcularCostoCOnsulta() {
		double costoBase = 45000;
		if (getEdad() > 10) {
			costoBase += 10000;
		}
		return costoBase;
	}

	@Override
	public double calcularCostoPeluqueria() {
		if (getPeso() <= 5) {
			return 28000;
		}
		else if (getPeso() > 5) {
			return 35000;
		} 
		return -1;
	}

	@Override
	public void vacunar() {
		if (vacunado) {
			throw new IllegalStateException ("Error, Ya esta vacuando");
		}
		else {
			vacunado = true;
		}
	}

	@Override
	public boolean estaVacunado() {
		return vacunado;
	}

}
