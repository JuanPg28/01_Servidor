package com.juanpeagarrido.cinema.webscine.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.services.IPeliculasService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestPeliculasController {
	class Respuesta {
		int code;
		String message;
		
		public Respuesta() {
			super();
		}

		public Respuesta(int code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
	}

	@Autowired
	IPeliculasService peliculasService;

	@GetMapping(path = "/peliculasJSON", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Pelicula> getPeliculas() {
		return peliculasService.findAll();
	}

	@GetMapping(path = "/peliculasJSON/findByAnyo", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Pelicula> getPeliculasByAnyo(@RequestParam(required = true) Integer estreno) {
		return peliculasService.findAllByAnyo(estreno);
	}
	
	@DeleteMapping(path = "/eliminarPeliculas", produces = {MediaType.APPLICATION_JSON_VALUE})
	Respuesta borrarPeliculas(@RequestParam(required=false)Integer id) {
			peliculasService.delete(id);
			return new Respuesta(0, "OK");
}
	
	@PostMapping(path = "/peliculasnew", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addPelicula(
			@RequestParam(required=false) Integer identificador,
			@RequestParam(required=false) String titulo,
			@RequestParam(required=false) String sinopsis,
			@RequestParam(required=false) Integer anyo,
			@RequestParam(required=false) String imagen,
			@RequestParam(required=false) String video) {
		try {
			peliculasService.save(new Pelicula(0, titulo, sinopsis, anyo, imagen, video));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
			return new Respuesta(0, "OK");
		
	}
	
	@PutMapping(path = "/peliculasmodi", produces = { MediaType.APPLICATION_JSON_VALUE})
	Respuesta updatePelis(
			@RequestParam(required=true) Integer identificador,
			@RequestParam(required=true) String titulo,
			@RequestParam(required=true) String sinopsis,
			@RequestParam(required=true) Integer anyo,
			@RequestParam(required=true) String imagen,
			@RequestParam(required=true) String video) {
		try {
			peliculasService.save(new Pelicula(identificador, titulo, sinopsis, anyo, imagen, video));
		} catch(Exception e) {
			return new Respuesta(-1, e.getMessage());
		}
			return new Respuesta(0, "OK");
	}
}
