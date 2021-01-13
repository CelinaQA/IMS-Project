package com.qa.ims.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInstance().getInput();
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long customer_id = Long.valueOf(getInput());
		Order order = orderService.create(new Order(customer_id, null));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = Long.valueOf(getInput());
		
		boolean stop = false;
		do {
			
		} while (!stop);
		
		LOGGER.info("What would you like to do with this order?");
		OrderUpdateOption.printOrderUpdateOptions();
		OrderUpdateOption option = OrderUpdateOption.getOrderUpdateOptions();
		
		switch(option) {
		case A:
			LOGGER.info("Please enter new customer ID");
			Long customer_id = Long.valueOf(getInput());
			orderService.update(new Order(id, customer_id));
			break;
		case B:
			LOGGER.info("Please enter ID of item ordered");
			Long item_id = Long.valueOf(getInput());
			LOGGER.info("Please enter quantity of item ordered");
			Integer item_quantity = Integer.valueOf(getInput());
			HashMap<Long, Integer> itemOrdered = new HashMap<Long, Integer>();
			itemOrdered.put(item_id, item_quantity);
			Order order = new Order(customer_id, itemOrdered);
			break;
		case C:
			break;
		case D:
			break;
		case STOP:
			stop = true;
			break;
		}
		
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
	}
}
