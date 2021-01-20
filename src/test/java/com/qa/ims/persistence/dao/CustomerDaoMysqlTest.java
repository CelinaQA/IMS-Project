package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDaoMysqlTest {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private static String DB_USER = "root";
	private static String DB_PASS = "root";
	private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/ims_test?allowMultiQueries=true";
	private static String DB_FILE = "src/test/resources/sql-schema.sql";

	@BeforeClass
	public static void init() {
		
		try (Connection connection = DBUtils.getInstance(DB_USER, DB_PASS).getConnection();
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
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orderlines; DELETE FROM items; DELETE FROM orders; DELETE FROM customers;");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql();
		String first_name = "Bob";
		String last_name = "Jones";
		Customer customer = new Customer(first_name, last_name);
		Customer savedCustomer = new Customer(1L, first_name, last_name);
		customer = customerDaoMysql.create(customer);
		assertEquals(savedCustomer, customer);
	}
	
}
