package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDaoMysqlTest {
	
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
	
	@Test
	public void createTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql();
		Item item = new Item("bread", 100, 2.99f);
		Item savedItem = new Item(1L,"bread", 100, 2.99f);
		item = itemDaoMysql.create(item);
		assertEquals(savedItem, item);
	}
	
	@Test
	public void readAllTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql();
		List<Item> items = new ArrayList<>();
		Item item1 = new Item(1L,"bread", 100, 2.99f);
		Item item2 = new Item(2L,"cookies", 150, 1.00f);
		items.add(item1);
		items.add(item2);
		itemDaoMysql.create(new Item("bread", 100, 2.99f));
		itemDaoMysql.create(new Item("cookies", 150, 1.00f));
		assertEquals(items, itemDaoMysql.readAll());
	} 
	
	@Test
	public void updateTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql();
		Item oldItem = new Item("bread", 100, 2.99f);
		Item newItem = new Item(1L,"oranges", 200, 0.99f);
		itemDaoMysql.create(oldItem);
		assertEquals(newItem, itemDaoMysql.update(newItem));
	}

}
