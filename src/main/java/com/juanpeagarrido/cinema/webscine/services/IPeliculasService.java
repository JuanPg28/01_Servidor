package com.juanpeagarrido.cinema.webscine.services;

import java.util.List;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;

public interface IPeliculasService {
	
	public void add(Pelicula p);
	public List<Pelicula> findAll();
	public void delete(Integer id);
	public List<Pelicula> findAllByAnyo(Integer estreno);


}
