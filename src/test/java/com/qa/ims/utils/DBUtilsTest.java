package com.qa.ims.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtilsTest {
	
	private static final Logger LOGGER = LogManager.getLogger();

	private final String DB_USER;

	private final String DB_PASS;

	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/ims_test?allowMultiQueries=true";

	private DBUtilsTest(String username, String password) {
		this.DB_USER = username;
		this.DB_PASS = password;

		try (Connection connection = this.getConnection();
				BufferedReader br = new BufferedReader(new FileReader("src/test/resources/sql-schema.sql"));) {
			String string;
			while ((string = br.readLine()) != null) {
				try (Statement statement = connection.createStatement();) {
					statement.executeUpdate(string);
				}
			}
		} catch (SQLException | IOException e) {
			for (StackTraceElement ele : e.getStackTrace()) {
				LOGGER.debug(ele);
			}
			LOGGER.error(e.getMessage());
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public static DBUtilsTest instance;

	public static DBUtilsTest getInstance(String username, String password) {
		if (instance == null) {
			instance = new DBUtilsTest(username, password);
		}
		return instance;
	}

	public static DBUtilsTest getInstance() {
		return instance;
	} 

}
