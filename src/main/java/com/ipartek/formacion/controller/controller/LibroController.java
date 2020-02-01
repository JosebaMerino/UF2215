package com.ipartek.formacion.controller.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.formacion.model.LibroDAO;
import com.ipartek.formacion.model.pojo.Libro;
import com.ipartek.formacion.utils.Utilidades;

/**
 * Servlet implementation class PokemonController
 */
@WebServlet("/api/libro/*")
public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static LibroDAO dao;

	private final static Logger LOG = LogManager.getLogger(LibroDAO.class);

	private Object responseObject = null;
	private int responseStatus = 0;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		LOG.trace("Init LIBRO CONTROLLER");
		super.init(config);
		dao = LibroDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		LOG.trace("destroy LIBRO CONTROLLER");
		dao = null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		super.service(request, response);

		// Manda el codigo de estado y la respuesta
		response.setStatus(responseStatus);
		if(responseObject != null) {
			try (PrintWriter out = response.getWriter()) {
				Gson json = new Gson();
				out.print(json.toJson(responseObject));
				out.flush();
			}
		}


	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean error = false;

		// recoger parametros
		String nombre = request.getParameter("nombre");
		int id = -1;
		try {
			id = Utilidades.obtenerId(request.getPathInfo());
		} catch (Exception e) {
			LOG.trace("La URL esta mal formada");
			LOG.trace(e);
			e.printStackTrace();
			error = true;
		}

		if (!error) {
			List<Libro> libros = null;
			// si se ha mandado un nombre hace una busqueda por nombre, sino se obtienen
			// todos los libros
			if
				(id != -1) {
					LOG.trace("Obteniendo un libro por el id " + id);
					responseObject = dao.getById(id);
					responseStatus = (responseObject == null ? HttpServletResponse.SC_NOT_FOUND : HttpServletResponse.SC_OK);
			} else if (nombre != null && nombre.length() > 0) {
				LOG.trace("Obteniendo libros por nombre= " + nombre);
				libros = dao.getByName(nombre);
				responseStatus = (libros.isEmpty() ? HttpServletResponse.SC_NO_CONTENT : HttpServletResponse.SC_OK);
				responseObject = libros;
			} else {
				LOG.trace("Obteniendo todos los libros");
				libros = dao.getAll();
				responseStatus = (libros.isEmpty() ? HttpServletResponse.SC_NO_CONTENT : HttpServletResponse.SC_OK);
				responseObject = libros;
			}
		} else {
			LOG.trace("Ha ocurrido un error");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

}
