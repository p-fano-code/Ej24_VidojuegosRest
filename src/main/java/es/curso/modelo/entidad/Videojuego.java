package es.curso.modelo.entidad;

public class Videojuego {

	private int id;
	private String nombre;
	private String compania;
	private float notaMedia;
	private int precio;
		
	public Videojuego() {
		
	}
	
	public Videojuego(int id, String nombre, String compania, double d, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.notaMedia = (float) d;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public float getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", notaMedia=" + notaMedia
				+ ", precio=" + precio + "]";
	}

	
	
	
}
