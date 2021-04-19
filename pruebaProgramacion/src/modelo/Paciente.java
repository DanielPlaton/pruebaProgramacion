package modelo;

import java.util.Random;

public class Paciente extends Persona implements Infectable, Moveable {

	int id;
	int id_ciudad;
	String nombre;
	String tipo;
	int infectado;

	public Paciente() {
		super();
	}

	public Paciente(int id, int id_ciudad, String nombre, String tipo, int infectado) {
		super();
		this.id = id;
		this.id_ciudad = id_ciudad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.infectado = infectado;
	}

	public Paciente(int id, int id_ciudad, String nombre, int infectado) {
		super();
		this.id = id;
		this.id_ciudad = id_ciudad;
		this.nombre = nombre;
		this.tipo = "P";
		this.infectado = infectado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getInfectado() {
		return infectado;
	}

	public void setInfectado(int infectado) {
		this.infectado = infectado;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", id_ciudad=" + id_ciudad + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", infectado=" + infectado + "]";
	}

	@Override
	public void infectar(boolean infectado) {
		if (infectado == true) {
			this.infectado = 1;
		} else {
			this.infectado = 0;
		}

	}

	@Override
	public boolean visitarSuper() {

		int porcentaje = 10;
		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;

	}

	@Override
	public boolean visitarTrabajo() {
		// TODO Auto-generated method stub

		int porcentaje = 12;
		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;

	}

	@Override
	public boolean cogerTransporte() {

		int porcentaje = 16;

		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;

	}

}
