package es.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ej24VideoJuegosRestApplication {

	public static void main(String[] args) {
		System.out.println("Servicio Rest -> Cargando el contexto de Spring...");
		SpringApplication.run(Ej24VideoJuegosRestApplication.class, args);
		System.out.println("Servicio Rest -> Contexto de Spring cargado!");
	}

}
