package com.ipartek.formacion.controller.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class PokemonController
 */
@WebServlet("/api/libro/*")
public class LibroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static LibroDAO dao;

	private final static Logger LOG = LogManager.getLogger(LibroDAO.class);

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametros
		String nombre = request.getParameter("nombre");

		List<Libro> libros = null;
		// si se ha mandado un nombre hace una busqueda por nombre, sino se obtienen
		// todos los libros
		if (nombre != null && nombre.length() > 0) {
			LOG.trace("Obteniendo libros por nombre= " + nombre);
			libros = dao.getByName(nombre);
		} else {
			LOG.trace("Obteniendo todos los libros");
			libros = dao.getAll();
		}

		if (libros.size() == 0) {
			// si la lista de libros esta vacia devuelve un codigo 204
			LOG.trace("La lista de libros esta vacia");
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			// si la lista de libros tiene libros devuelve un codigo 200 y todos los libros en formato JSON
			LOG.trace("La lista de libros contiene " + libros.size() + " libro" + (libros.size() == 1 ? "" : "s"));
			try (PrintWriter out = response.getWriter()) {

				response.setStatus(HttpServletResponse.SC_OK);
				Gson json = new Gson();
				out.print(json.toJson(libros));
				out.flush();

			}
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
