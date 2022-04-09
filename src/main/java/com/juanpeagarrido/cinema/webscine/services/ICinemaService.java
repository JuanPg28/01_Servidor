package com.juanpeagarrido.cinema.webscine.services;

import java.util.List;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;

public interface ICinemaService {
	
	public void addCinema(Pelicula c);
	public List<Pelicula> findAll();


}
