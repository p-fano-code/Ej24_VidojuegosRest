package es.curso.modelo.serviciorest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.persistencia.DaoVideojuego;

@RestController
public class ControladorVideojuego {

	@Autowired
	private DaoVideojuego daoJuego;
	
	@GetMapping(path = "videojuego/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id){
		System.out.println("Buscando juego con id: " + id);
		Videojuego v = daoJuego.get(id);
		if (v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
		}else return new ResponseEntity<Videojuego>(v,HttpStatus.NOT_FOUND);
	}
	
		
	@GetMapping(path="videojuegos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarJuegos(
			@RequestParam(name="nombre",required=false) String nombre) {
		List<Videojuego> listaJuegos = null;
		//Si no me viene el nombre, devolvemos toda la lista
		if(nombre == null) {
			System.out.println("Listando los juegos");
			listaJuegos = daoJuego.listar();			
		}else {
			System.out.println("Listando las personas por nombre: " + nombre);
			listaJuegos = daoJuego.listarPorNombre(nombre);
		}
		System.out.println(listaJuegos);
		return new ResponseEntity<List<Videojuego>>(listaJuegos,HttpStatus.OK);
	}
	
	//alta de videojuego
	
	@PostMapping(path="videojuego",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaPersona(@RequestBody Videojuego v) {
		System.out.println("altaJuego: objeto persona: " + v);
		daoJuego.aniadir(v);
		return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);//201 CREATED
	}
	
	//METODO PUT
	@PutMapping(path="videojuego/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(
			@PathVariable("id") int id, 
			@RequestBody Videojuego v) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + v);
		v.setId(id);
		Videojuego vUpdate = daoJuego.actualizar(v);
		if(vUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	 //METODO DELETE
	@DeleteMapping(path="videojuego/{id}")
	public ResponseEntity<Videojuego> borrarJuego(@PathVariable int id) {
		System.out.println("ID a borrar: " + id);
		Videojuego v = daoJuego.borrar(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
}
