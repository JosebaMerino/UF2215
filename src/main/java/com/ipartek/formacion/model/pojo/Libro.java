package com.ipartek.formacion.model.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Libro{

	@Min(value = 0)
	private int id;

	@NotBlank
	@Length(max = 100, min = 1)
	private String nombre;

	@NotNull
	private Autor autor;


	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.autor = new Autor();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + "]";
	}





}
