package com.br.service.connectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnetorBase {
	public Connection conectaBase() throws SQLException;
}
