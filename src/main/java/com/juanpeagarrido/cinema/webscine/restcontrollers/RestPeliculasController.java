package com.juanpeagarrido.cinema.webscine.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(path = "/peliculasnew", produces = { MediaType.APPLICATION_JSON_VALUE })
	Respuesta addPelicula(
			@RequestParam(required=false) Integer identificador,
			@RequestParam(required=false) String titulo,
			@RequestParam(required=false) String sinopsis,
			@RequestParam(required=false) Integer anyo,
			@RequestParam(required=false) String imagen,
			@RequestParam(required=false) String video) {
		peliculasService.save(new Pelicula(titulo, sinopsis, anyo, imagen, video));
		return new Respuesta(0, "OK");
		
	}

}
