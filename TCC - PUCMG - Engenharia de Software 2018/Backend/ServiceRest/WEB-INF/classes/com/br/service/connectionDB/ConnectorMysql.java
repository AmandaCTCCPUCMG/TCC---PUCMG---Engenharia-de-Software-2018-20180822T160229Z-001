package com.br.service.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorMysql implements ConnetorBase {

	public Connection conectaBase() throws SQLException {
		return getconexao();
	}

	public Connection getconexao() throws SQLException {
		try {

			String driver = "com.mysql.jdbc.Driver";
			String conexao = "jdbc:mysql://localhost:3306/comercio_rest";

			Class.forName(driver);

			String user = "root";
			String pass = "";

			//String user = "ageadmin";
			//String pass = "@ageadmin@";

			Connection db = DriverManager.getConnection(conexao, user, pass);

			return db;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return null;
	}

}
