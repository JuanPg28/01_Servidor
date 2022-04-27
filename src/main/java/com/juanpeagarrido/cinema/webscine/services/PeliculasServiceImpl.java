package com.juanpeagarrido.cinema.webscine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.repository.IPeliculasRepository;

@Service
public class PeliculasServiceImpl implements IPeliculasService {
	
	final static int ANYO_MINIMO=2018;

	@Autowired
	IPeliculasRepository repo;

	@Override
	public void add(Pelicula p) {
		repo.save(p);

	}
	
	@Override
	public List<Pelicula> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Pelicula> findAllByAnyo(Integer estreno) {
		List<Pelicula> peliculas = repo.findAllByAnyo(estreno);
		return peliculas;
	}

	@Override
	public void save(Pelicula p) throws Exception {
		if (p.getAnyo()<ANYO_MINIMO) {
			throw new Exception("El año de estreno debe ser mayor al " + ANYO_MINIMO);
		}
		repo.save(p);
		
	}

	@Override
	public void update(Pelicula modi) {
		repo.save(modi);
		
	}
	


}
