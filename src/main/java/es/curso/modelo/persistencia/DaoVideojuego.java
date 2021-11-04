package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import es.curso.modelo.entidad.Videojuego;
@Component
public class DaoVideojuego {

	public List<Videojuego> listaJuegos;
	public int id = 0;
	
	public DaoVideojuego() {
		System.out.println("Creando lista de videojuegos");
		listaJuegos = new ArrayList<Videojuego>();
		Videojuego v1 = new Videojuego(id++, "GTA V", "Rockstar", 9, 19);
		Videojuego v2 = new Videojuego(id++, "Biosock", "EA", 6, 32);
		Videojuego v3 = new Videojuego(id++, "FIFA", "EA", 8, 23);
		Videojuego v4 = new Videojuego(id++, "NBA", "2k", 10, 41);
		Videojuego v5 = new Videojuego(id++, "RDR2", "Rockstar", 10, 59);
		
		listaJuegos.add(v1);
		listaJuegos.add(v2);
		listaJuegos.add(v3);
		listaJuegos.add(v4);
		listaJuegos.add(v5);
		
	}
	
	public Videojuego get(int id) {
		try {
			return listaJuegos.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Videojuego fuera de rango o inexistente");
			return null;
		}
	}
	
	public List<Videojuego> listar(){
		return listaJuegos;
	}
	
	public void aniadir(Videojuego v) {
		v.setId(id++);
		listaJuegos.add(v);
	}
	
	public Videojuego borrar(int id) {
		try {
			return listaJuegos.remove(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Videojuego fuera de rango o inexistente");
			return null;
		}
	}
	
	public Videojuego actualizar(Videojuego v) {
		try {
			Videojuego v1 = listaJuegos.get(v.getId());
			if(v1 != null) {
				v1.setNombre(v.getNombre());
				v1.setCompania(v.getCompania());
				v1.setNotaMedia(v.getNotaMedia());
			}
			return v1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Videojuego fuera de rango o inexistente");
			return null;
		}
	}
	
	public List<Videojuego> listarPorNombre(String nombre){
		List<Videojuego> listaAux = new ArrayList<Videojuego>();
		for (Videojuego v : listaJuegos) {
			if(v.getNombre().equalsIgnoreCase(nombre)){
				listaAux.add(v);
			}
		}
		return listaAux;
	}
	
	public List<Videojuego> listarPorCompania(String compania){
		List<Videojuego> listaAux = new ArrayList<Videojuego>();
		for (Videojuego v : listaJuegos) {
			if(v.getCompania().equalsIgnoreCase(compania)){
				listaAux.add(v);
			}
		}
		return listaAux;
	}
	
	public List<Integer> listaPrecios(){
		int total = 0;
		List<Integer> listaPrecios = new ArrayList<Integer>();
		for (Videojuego videojuego : listaJuegos) {
			listaPrecios.add((int) videojuego.getPrecio());
			total += videojuego.getPrecio();
		}
		listaPrecios.add(total);
		return listaPrecios;
	}
	
}
