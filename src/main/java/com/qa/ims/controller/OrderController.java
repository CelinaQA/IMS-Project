package com.qa.ims.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderCrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderCrudServices<Order> orderService;
	
	public OrderController(OrderCrudServices<Order> orderService) {
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
		LOGGER.info("Please enter ID of item ordered");
		Long item_id = Long.valueOf(getInput());
		LOGGER.info("Please enter quantity of item ordered");
		Integer quantity = Integer.valueOf(getInput());
		Order order = orderService.create(new Order(customer_id, item_id, quantity));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter customer ID");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long order_id = Long.valueOf(getInput());
		Order order = new Order(order_id, customer_id);
		
		LOGGER.info("What would you like to do with this order?");
		OrderUpdateOption.printOrderUpdateOptions();
		OrderUpdateOption option = OrderUpdateOption.getOrderUpdateOptions();
		
		Long item_id;
		Integer quantity;
		HashMap<Long, Integer> itemOrdered = new HashMap<Long, Integer>();

		switch(option) {
		case A:
			LOGGER.info("Please enter ID of item you want to add");
			item_id = Long.valueOf(getInput());
			LOGGER.info("Please enter quantity of item ordered");
			quantity = Integer.valueOf(getInput());
			itemOrdered.put(item_id, quantity);
			order = orderService.updateAddItem(order, item_id, quantity);
			LOGGER.info("Order Updated");
			return order;
		case B:
			LOGGER.info("Please enter ID of item you want to delete");
			item_id = Long.valueOf(getInput());
			order = orderService.updateDelItem(order, item_id);
			LOGGER.info("Order Updated");
			return order;
		case STOP:
			break;
		}
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
		LOGGER.info("Order deleted");
	}
}
