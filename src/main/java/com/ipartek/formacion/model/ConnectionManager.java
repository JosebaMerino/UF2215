package com.ipartek.formacion.model;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class ConnectionManager {

	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	private static Connection conn;

	public static Connection getConnection() {

		conn = null;

		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");

			if (ds == null) {
				throw new Exception("Data source no encontrado!");
			}

			conn = ds.getConnection();

		} catch (Exception e) {

			LOG.fatal("El error puede que se deba al puerto al que se conecta. Por defecto es el 3306 pero en el ordenador que se ha implementado la aplicacion es el 3308.");
			LOG.fatal(e);
		}

		return conn;

	}

}
