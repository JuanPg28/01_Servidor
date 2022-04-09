package com.juanpeagarrido.cinema.webscine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.services.IPeliculasService;

@Controller
public class PeliculasController {
	
	@Autowired
	private IPeliculasService peliculasService;
	
	@RequestMapping(value = "/crearPeliculas")
	public ModelAndView crearPeliculas(
			@RequestParam(required=false) Integer identificador,
			@RequestParam(required=false) String titulo,
			@RequestParam(required=false) String sinopsis,
			@RequestParam(required=false) Integer anyo,
			@RequestParam(required=false) String imagen,
			@RequestParam(required=false) String video) {
		if(titulo!=null) {
			Pelicula p = new Pelicula(titulo, sinopsis, anyo, imagen, video);
			peliculasService.add(p);
			return new ModelAndView("redirect:/crearPeliculas");
		}
		List<Pelicula> peliculas = peliculasService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("crear_peliculas");
		mav.addObject("lista_peliculas", peliculas);
		return mav;
	}
	
	@RequestMapping(value = "/borrarPeliculas")
		public ModelAndView borrarPeliculas(
				@RequestParam(required=false)Integer id) {
				peliculasService.delete(id);
				return new ModelAndView("redirect:/crearPeliculas");
	}

}
