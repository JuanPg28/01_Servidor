package com.juanpeagarrido.cinema.webscine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;
import com.juanpeagarrido.cinema.webscine.repository.ICinemaRepository;

@Service
public class CinemaServiceImpl implements ICinemaService {
	
	@Autowired
	ICinemaRepository repo;

	@Override
	public void addCinema(Pelicula c) {
		repo.save(c);

	}

	@Override
	public List<Pelicula> findAll() {
		return repo.findAll();
	}

}
