package Modelo;

public abstract class Mascota {
	private final String codigo;
	private String nombre;
	private int edad;
	private double peso;
	private String nombrePropietario;
	
	public Mascota(String codigo, String nombre, int edad, double peso, String nombrePropietario) {
	this.codigo = codigo;
	getNombre();
	getEdad();
	getPeso();
	getNombrePropietario();
	verificarInvariante();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.trim().isEmpty() ) {
			this.nombre = nombre;
		}
		else {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
	}


	public int getEdad() {
			return edad;
	}


	public void setEdad(int edad) {
		if (edad < 0 ) {
			this.edad = edad;
		}
		else {
			throw new IllegalArgumentException("La edad no puede ser mayor");
		}
	
		
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		if (peso < 0 ) {
			this.peso = peso;
		}
		else {
			throw new IllegalArgumentException("El peso no puede ser menor que 0");
		}
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		if (nombrePropietario != null && !nombrePropietario.trim().isEmpty() ) {
			this.nombrePropietario = nombrePropietario;
		}
		else {
			throw new IllegalArgumentException("El nombre del propietario no puede estar vacio");
		}
		
	}

	public String getCodigo() {
		return codigo;
	}

	private void verificarInvariante() {
		assert codigo != null && !codigo.trim().isEmpty() : "Error, el codigo no puede estar vacio" ;
		assert nombre != null && !codigo.trim().isEmpty() : "Error, el nombre no puede estar vacio";
		assert peso < 0 : "Error, el peso tiene que ser mayor que 0";
		assert edad < 0 : "Error, la edad tiene que ser mayor que 0";
		assert nombrePropietario != null && !nombrePropietario.trim().isEmpty() : "Error, el nombre del propietario no puede estar vacio";
	}
	
	public abstract String getTipo();
	public abstract String emitirSonido();
	public abstract double calcularCostoCOnsulta();
	
}
