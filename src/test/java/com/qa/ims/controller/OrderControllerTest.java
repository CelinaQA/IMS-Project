package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

public class OrderControllerTest {
	
	@Mock
	private OrderServices orderServices;
	
	@Spy
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, 1));
		orders.add(new Order(2L, 2L, 2));
		orders.add(new Order(3L, 3L, 3));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}
	
	@Test
	public void createTest() {
		String customer_id = "1";
		String item_id = "1";
		String quantity = "3";
		Mockito.doReturn(customer_id,item_id,quantity).when(orderController).getInput();
		Order order = new Order(1L, 1L, 3);
		Order savedOrder = new Order(1L, 1L, 1L, 3);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}
	
	@Test
	public void updateTest() {
		String order_id = "1";
		String customer_id = "1";
		String item_id = "1";
		String quantity = "3";
		Mockito.doReturn(order_id,customer_id,item_id,quantity).when(orderController).getInput();
		Order order = new Order(1L, 1L, 1L, 3);
		Mockito.when(orderServices.updateAddItem(order, item_id, item_quantity)).thenReturn(order);
		assertEquals(order, orderController.update());
	}

}
