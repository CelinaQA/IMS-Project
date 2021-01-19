package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1L, "bread", 100, 0.99f);
		other = new Item(1L, "bread", 100, 0.99f);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getName());
		assertNotNull(item.getPrice());
		assertNotNull(item.getStock());
		
		item.setId(null);
		assertNull(item.getId());
		item.setName(null);
		assertNull(item.getName());
		item.setPrice(null);
		assertNull(item.getPrice());
		item.setStock(null);
		assertNull(item.getStock());

	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("bread", item.getName());
		assertEquals(0.99f, item.getPrice(),0);
		assertEquals(100, item.getStock(),0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setName("milk");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullID() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullNameOnBoth() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullPrice() {
		item.setPrice(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPriceOnBoth() {
		item.setPrice(null);
		other.setPrice(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setPrice(1.99f);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullStock() {
		item.setStock(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullStockOnBoth() {
		item.setStock(null);
		other.setStock(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherStockDifferent() {
		other.setStock(101);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null, null);
		Item other = new Item(null, null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Item ID: 1" +"\n"+"Name: bread" +"\n"+ "Stock: 100" +"\n"+ "Price: £0.99";
		assertEquals(toString, item.toString());
	}

}
