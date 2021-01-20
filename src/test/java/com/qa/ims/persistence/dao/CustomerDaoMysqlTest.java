package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private static String DB_USER = "root";
	private static String DB_PASS = "root";
	private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ims_test?allowMultiQueries=true";
	private static String DB_FILE = "src/test/resources/sql-schema.sql";

	@BeforeClass
	public static void init() {
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				BufferedReader br = new BufferedReader(new FileReader(DB_FILE));) {
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
	
	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(DB_URL, DB_USER, DB_PASS);
		String first_name = "Bob";
		String last_name = "Jones";
		Customer customer = new Customer(first_name, last_name);
		Customer savedCustomer = new Customer(first_name, last_name);
		customer = customerDaoMysql.create(customer);
		assertEquals(savedCustomer, customer);
	}
	
}
