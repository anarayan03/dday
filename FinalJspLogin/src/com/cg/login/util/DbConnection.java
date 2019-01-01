package com.cg.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.exception.ExceptionMessages;

public class DbConnection {

	private static Connection connection=null;
	public static Connection getConnection() throws LoginException {
		if(connection==null) {
			try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcli","scott","adi");
			}catch(SQLException e) {
				throw new LoginException(ExceptionMessages.MESSAGE1);
			}
		}
		return connection;
	}
}
