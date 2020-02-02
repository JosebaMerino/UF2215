package com.ipartek.formacion.model.pojo;

import javax.validation.constraints.Min;

public class Autor {
	@Min(value = 1)
	private int id;

	private String nombre;

	public Autor() {
		super();
		this.id = 0;
		this.nombre = "";
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

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + "]";
	}




}
