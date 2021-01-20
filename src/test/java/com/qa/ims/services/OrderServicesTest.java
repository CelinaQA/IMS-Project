package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {
	
	@Mock
	private OrderDao<Order> orderDao;
	
	@InjectMocks
	private OrderServices orderServices;
	
	@Test
	public void itemServicesCreate() {
		Order order = new Order(1L, 1L, 3);
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void itemServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdateAdd() {
		Order order = new Order(1L, 1L, 3);
		orderServices.updateAddItem(order, 2L, 5);
		Mockito.verify(orderDao, Mockito.times(1)).updateAddItem(order, 2L, 5);
	}
	
	@Test
	public void itemServicesUpdateDel() {
		Order order = new Order(1L, 1L, 3);
		orderServices.updateDelItem(order, 1L);
		Mockito.verify(orderDao, Mockito.times(1)).updateDelItem(order, 1L);
	}
	
	@Test
	public void itemServicesDelete() {
		orderServices.delete(1L);;
		Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
	}

}
