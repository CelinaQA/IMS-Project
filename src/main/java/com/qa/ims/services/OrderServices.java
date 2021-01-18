package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Order;

public class OrderServices implements OrderCrudServices<Order>{
	
	private OrderDao<Order> orderDao;
	
	public OrderServices(OrderDao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order order) {
		return orderDao.create(order);
	}

	public Order updateDelItem(Order order, Long item_id) {
		return orderDao.updateDelItem(order, item_id);
	}
	
	public Order updateAddItem(Order order, Long item_id, Integer item_quantity) {
		return orderDao.updateAddItem(order, item_id, item_quantity);
	}

	public void delete(Long id) {		
		orderDao.delete(id);
	}
	
}
