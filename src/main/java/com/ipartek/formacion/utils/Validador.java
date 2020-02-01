package com.ipartek.formacion.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validador<T> {

	// Crear Factoria y Validador
	private ValidatorFactory factory;
	private Validator validator;

	public Validador() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * Valida el objeto pasado
	 * @param objeto - objeto a validar
	 * @return List &ltString&gt - Lista de errores de validacion. Si no se encuentra ningun error devuelve la lista vacia.
	 */
	public List<String> validar(T objeto) {
		List<String> resul = new ArrayList<String>();
		Set<ConstraintViolation<T>> errores = validator.validate(objeto);
		if (errores.size() > 0) {
			for (ConstraintViolation<T> error : errores) {
				resul.add(error.getPropertyPath() + " - " + error.getMessage());
			}
		}
		return resul;
	}
}
