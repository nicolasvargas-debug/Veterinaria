package Modelo;

public abstract class Mascota {
	private final String codigo;
	private String nombre;
	private int edad;
	private double peso;
	private String nombrePropietario;
	
	public Mascota(String codigo, String nombre, int edad, double peso, String nombrePropietario) {
	this.codigo = codigo;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if 
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getCodigo() {
		return codigo;
	}

	private void invariante() {
		assert codigo != null && !codigo.isEmpty() : "Error el codigo no puede estar vacio" ;
	}
	
}
