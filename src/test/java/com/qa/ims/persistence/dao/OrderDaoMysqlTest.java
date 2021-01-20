package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDaoMysqlTest {
	
public static final Logger LOGGER = LogManager.getLogger();
	
	private static String DB_USER = "root";
	private static String DB_PASS = "root";
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
		try (Connection connection = DBUtils.getInstance(DB_USER, DB_PASS).getConnection();
				BufferedReader br = new BufferedReader(new FileReader("src/test/resources/sql-data.sql"));) {
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
	
	@Test
	public void createTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql();
		Order order = new Order(1L, 1L, 3);
		Date date = Calendar.getInstance().getTime();
		order = orderDaoMysql.create(order);
		Order savedOrder = new Order(100L, 1L, date, 3f, 1L, 3);
		assertEquals(savedOrder, order);
	}
	
	@Test
	public void readAllTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql();
		List<Order> orders = new ArrayList<>();
		Date date = Calendar.getInstance().getTime();
		Order order1 = new Order(100L, 1L, date, 1f, 1L, 1);
		Order order2 = new Order(101L, 2L, date, 1f, 2L, 1);
		orders.add(order1);
		orders.add(order2);
		orderDaoMysql.create(new Order(1L, 1L, 1));
		orderDaoMysql.create(new Order(2L, 2L, 1));
		assertEquals(orders, orderDaoMysql.readAll());
		
	}
	
	@Test
	public void updateAddTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql();
	}

}
