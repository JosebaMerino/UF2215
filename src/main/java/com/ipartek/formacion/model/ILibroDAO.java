package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.model.pojo.Libro;

public interface ILibroDAO extends IDAO<Libro> {

	/**
	 * Busca libros que contengan nombre
	 * @param nombre - por el que se desea buscar
	 * @return lista de libros que contienen nombre
	 */
	List<Libro> getByName(String nombre);
}
