package com.qa.ims;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
//		IMS ims = new IMS();
//		ims.imsSystem();
		
		HashMap<Long, Integer> itemsOrdered = new HashMap<>();
		itemsOrdered.put(123L, 2);
		itemsOrdered.put(456L, 10);
		itemsOrdered.put(789L, 9);
		Order order = new Order(1L, itemsOrdered);
		System.out.println(order);
	}

}
