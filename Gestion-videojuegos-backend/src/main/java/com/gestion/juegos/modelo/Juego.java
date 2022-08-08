package com.gestion.juegos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Juegos")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NombreJuego", length = 50, nullable = false)
	private String Nombre_juego;

	@Column(name = "Plataforma", length = 50, nullable = false)
	private String Plataforma;

	@Column(name = "TipoJuego", length = 50, nullable = false)
	private String Tipo_juego;

	@Column(name = "Calificacion", length = 1, nullable = false)
	private int Calificacion;

	public Juego() {

	}

	public Juego(Long id, String nombre_juego, String plataforma, String tipo_juego, int calificacion) {
		super();
		this.id = id;
		Nombre_juego = nombre_juego;
		Plataforma = plataforma;
		Tipo_juego = tipo_juego;
		Calificacion = calificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_juego() {
		return Nombre_juego;
	}

	public void setNombre_juego(String nombre_juego) {
		Nombre_juego = nombre_juego;
	}

	public String getPlataforma() {
		return Plataforma;
	}

	public void setPlataforma(String plataforma) {
		Plataforma = plataforma;
	}

	public String getTipo_juego() {
		return Tipo_juego;
	}

	public void setTipo_juego(String tipo_juego) {
		Tipo_juego = tipo_juego;
	}

	public int getCalificacion() {
		return Calificacion;
	}

	public void setCalificacion(int calificacion) {
		Calificacion = calificacion;
	}

}
