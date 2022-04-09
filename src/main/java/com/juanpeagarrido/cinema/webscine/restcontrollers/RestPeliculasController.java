package com.juanpeagarrido.cinema.webscine.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.services.IPeliculasService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestPeliculasController {
	
	@Autowired
	IPeliculasService peliculasService;
	
	@GetMapping(path="/peliculasJSON", produces= {MediaType.APPLICATION_JSON_VALUE})
	List<Pelicula> getPeliculas(){
		return peliculasService.findAll();
	}
	
	@GetMapping(path="/peliculasJSON/findByAnyo", produces= {MediaType.APPLICATION_JSON_VALUE})
	List<Pelicula> getPeliculasByAnyo(@RequestParam(required = true) Integer estreno){
		return peliculasService.findAllByAnyo(estreno);
	}

}
