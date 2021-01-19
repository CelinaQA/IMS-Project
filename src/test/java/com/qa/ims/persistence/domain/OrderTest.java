package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(100L, 1L, Calendar.getInstance().getTime(), 0.99f, 1L, 3);
		other = new Order(100L, 1L, Calendar.getInstance().getTime(), 0.99f, 1L, 3);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getCustomer_id());
		assertNotNull(order.getDate_placed());
		assertNotNull(order.getId());
		assertNotNull(order.getItem_id());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getTotalPrice());
		
		order.setCustomer_id(null);
		assertNull(order.getCustomer_id());
		order.setDate_placed(null);
		assertNull(order.getDate_placed());
		order.setId(null);
		assertNull(order.getId());
		order.setItem_id(null);
		assertNull(order.getItem_id());
		order.setQuantity(null);
		assertNull(order.getQuantity());
		order.setTotalPrice(null);
		assertNull(order.getTotalPrice());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(100L, order.getId(), 0);
		assertEquals(1L, order.getCustomer_id(),0);
		assertEquals(0.99f, order.getTotalPrice(),0);
		assertEquals(1L, order.getItem_id(),0);
		assertEquals(3, order.getQuantity(),0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullCustomerId() {
		order.setCustomer_id(null);;
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCustomerIdOnBoth() {
		order.setCustomer_id(null);
		other.setCustomer_id(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherCustomerIdDifferent() {
		other.setCustomer_id(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setId(null);
		other.setId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(101L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItemId() {
		order.setItem_id(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItemIdOnBoth() {
		order.setItem_id(null);
		other.setItem_id(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherItemIdDifferent() {
		other.setItem_id(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantity() {
		order.setQuantity(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantityOnBoth() {
		order.setQuantity(null);
		other.setQuantity(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(1);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullTotalPrice() {
		order.setTotalPrice(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullTotalPriceOnBoth() {
		order.setTotalPrice(null);
		other.setTotalPrice(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherTotalPriceDifferent() {
		other.setTotalPrice(1.00f);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullDate_placed() {
		order.setDate_placed(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullDate_placedOnBoth() {
		order.setDate_placed(null);
		other.setDate_placed(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherDate_placedDifferent() {
		other.setDate_placed(Calendar.getInstance().getTime());
		assertFalse(order.equals(other));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null, null, null);
		Order other = new Order(null, null, null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Order ID = 100" +"\n"+ "Customer ID = 1" +"\n"+"Date placed = " +Calendar.getInstance().getTime()+ "\n"+
				"Total price: £0.99";
		assertEquals(toString, order.toString());
	}

}
