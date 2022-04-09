package com.juanpeagarrido.cinema.webscine;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.repository.IPeliculasRepository;
import com.juanpeagarrido.cinema.webscine.services.IPeliculasService;

@SpringBootTest
class WebscineApplicationTests {
	
	@Autowired
	IPeliculasRepository peliculasRepository;
	@Autowired
	IPeliculasService peliculasService;

	//@Test
	void findAllPeliculas() {
		List<Pelicula> peliculas = peliculasRepository.findAll();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula.getTitulo());
		}
	}
	
	//@Test
	void findAllPeliculasService() {
		List<Pelicula> peliculas = peliculasService.findAll();
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula.getTitulo());
		}
	}
	
	@Test
	void findAllPeliculasServiceByAnyo() {
		List<Pelicula> peliculas = peliculasService.findAllByAnyo(2022);
		for (Pelicula pelicula : peliculas) {
			System.out.println(pelicula.getTitulo());
		}
	}


}
