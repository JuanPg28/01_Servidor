package com.juanpeagarrido.cinema.webscine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.services.ICinemaService;

@Controller
public class CinemaController {
	
	@Autowired
	private ICinemaService cinemaService;
	
	@RequestMapping(value="/cinemaweb")
	public ModelAndView cinema() {
		
		List<Pelicula> cinema = cinemaService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cinema.com");
		mav.addObject("tipos_cinema", cinema);
		return mav;
	}

}
