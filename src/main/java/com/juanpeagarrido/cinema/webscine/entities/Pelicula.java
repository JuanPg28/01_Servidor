package com.juanpeagarrido.cinema.webscine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="peliculas")
public class Pelicula {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Identificador;
	private String Titulo;
	private String Sinopsis;
	private Integer Anyo;
	private String Imagen;
	private String Video;
	
	//Constructor vacio
	public Pelicula() {
		super();
	}

	

	//Constructor completo sin Id
	public Pelicula(Integer identificador, String titulo, String sinopsis, Integer anyo, String imagen, String video) {
		super();
		Identificador = identificador;
		Titulo = titulo;
		Sinopsis = sinopsis;
		Anyo = anyo;
		Imagen = imagen;
		Video = video;
	}

	
	//Getter and Setter
	public Integer getIdentificador() {
		return Identificador;
	}



	public void setIdentificador(Integer identificador) {
		Identificador = identificador;
	}



	public String getTitulo() {
		return Titulo;
	}



	public void setTitulo(String titulo) {
		Titulo = titulo;
	}



	public String getSinopsis() {
		return Sinopsis;
	}



	public void setSinopsis(String sinopsis) {
		Sinopsis = sinopsis;
	}



	public Integer getAnyo() {
		return Anyo;
	}



	public void setAnyo(Integer anyo) {
		Anyo = anyo;
	}



	public String getImagen() {
		return Imagen;
	}



	public void setImagen(String imagen) {
		Imagen = imagen;
	}



	public String getVideo() {
		return Video;
	}



	public void setVideo(String video) {
		Video = video;
	}
	

}
