package modelo;

public class Persona  {

	int id;
	int id_ciudad;
	String nombre;
	String tipo;
	int infectado;

	public Persona() {
		super();
	}

	public Persona(int id, int id_ciudad, String nombre, String tipo, int infectado) {
		super();
		this.id = id;
		this.id_ciudad = id_ciudad;
		this.nombre = nombre;
		this.tipo = tipo;
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
		return "Persona [id=" + id + ", id_ciudad=" + id_ciudad + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", infectado=" + infectado + "]";
	}

}
