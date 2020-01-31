package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.controller.LibroController;
import com.ipartek.formacion.model.pojo.Autor;
import com.ipartek.formacion.model.pojo.Libro;

public class LibroDAO implements ILibroDAO {

	private static LibroDAO INSTANCE;
	private final static Logger LOG = LogManager.getLogger(LibroDAO.class);

	private final String SQL_GET_ALL = "SELECT l.id 'idLibro', l.nombre 'nombreLibro', a.id 'idAutor', a.nombre 'nombreAutor' FROM libro l, autor a WHERE l.idAutor = a.id ORDER BY l.id ASC LIMIT 500;";
	private final String SQL_GET_BYNAME = "SELECT l.id 'idLibro', l.nombre 'nombreLibro', a.id 'idAutor', a.nombre 'nombreAutor' FROM libro l, autor a WHERE l.idAutor = a.id AND l.nombre LIKE ? ORDER BY l.idAutor ASC LIMIT 500;";

	private LibroDAO() {
		super();
	}

	public static synchronized LibroDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibroDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Libro> getAll() {
		LOG.trace("GET ALL");
		ArrayList<Libro> registros = new ArrayList<Libro>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);) {
			LOG.debug(pst);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					registros.add(mapper(rs));
				}
			}

		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}

		return registros;
	}

	@Override
	public Libro getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro update(int id, Libro pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro create(Libro pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> getByName(String nombre) {
		LOG.trace("GET BY NAME nombre= " + nombre);
		ArrayList<Libro> registros = new ArrayList<Libro>();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BYNAME);) {
			pst.setString(1, nombre);
			LOG.debug(pst);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					registros.add(mapper(rs));
				}
			}

		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}

		return registros;
	}

	private Libro mapper(ResultSet rs) throws SQLException {
		Libro p = new Libro();
		p.setId(rs.getInt("idLibro"));
		p.setNombre(rs.getString("nombreLibro"));

		Autor autor = p.getAutor();
		autor.setId(rs.getInt("idAutor"));
		autor.setNombre(rs.getString("nombreAutor"));
		return p;
	}

}
