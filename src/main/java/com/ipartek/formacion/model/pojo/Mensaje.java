package com.ipartek.formacion.model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se usa exclusivamente para mandar mensajes al consumidor del servicio REST en caso de error
 * @author joseb
 *
 */
public class Mensaje {
	private String mensaje;
	private List<String> errores;

	public Mensaje() {
		super();
		this.mensaje = "";
		this.errores = new ArrayList<String>();
	}

	public Mensaje(String mensaje) {
		this();
		this.mensaje = mensaje;
	}

	public Mensaje(String mensaje, List<String> errores) {
		this(mensaje);
		this.errores = errores;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<String> getErrores() {
		return errores;
	}

	public void setErrores(List<String> errores) {
		this.errores = errores;
	}

	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + ", errores=" + errores + "]";
	}



}
