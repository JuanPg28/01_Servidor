package com.juanpeagarrido.cinema.webscine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;

public interface IPeliculasRepository extends JpaRepository<Pelicula, Integer>{ 
	
	@Query ("select v from peliculas v where anyo like %:estreno%")
	List<Pelicula> findAllByAnyo(Integer estreno);

}
