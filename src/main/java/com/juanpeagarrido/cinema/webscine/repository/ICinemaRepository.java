package com.juanpeagarrido.cinema.webscine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanpeagarrido.cinema.webscine.entities.Pelicula;

public interface ICinemaRepository extends JpaRepository<Pelicula, Integer>{

}
