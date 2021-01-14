package com.qa.ims.persistence.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Order {
	
	private Long id;
	private Long customer_id;
	private Date date_placed = Calendar.getInstance().getTime();
	
	//Orderline
	private HashMap<Long, Integer> itemsOrdered = new HashMap<Long, Integer>();

	//to read
	public Order(Long id, Long customer_id, Date date_placed, HashMap<Long, Integer> itemsOrdered) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.itemsOrdered = itemsOrdered;
	}

	//to create and to update items ordered
	public Order(Long customer_id, HashMap<Long, Integer> itemsOrdered) {
		super();
		this.customer_id = customer_id;
		this.itemsOrdered = itemsOrdered;
	}
	
	//to select specific order for customer
	public Order(Long order_id, Long customer_id) {
		super();
		this.id = order_id;
		this.customer_id = customer_id;
	}

	//Default constructor
	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Date getDate_placed() {
		return date_placed;
	}

	public void setDate_placed(Date date_placed) {
		this.date_placed = date_placed;
	}
	
	public HashMap<Long, Integer> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(HashMap<Long, Integer> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	@Override
	public String toString() {
		return "Order ID = " + id + "\n"+ "Customer ID = " + customer_id + "\n"+"Date placed = " + date_placed + "\n"+
				printItemsOrdered();
	}
	
	public String printItemsOrdered() {
		String str = "";
		
		for (Long key : itemsOrdered.keySet()) {
			str += "Item ID: " + key + "  Quantity: " + itemsOrdered.get(key) + "\n";
		} 
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((date_placed == null) ? 0 : date_placed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemsOrdered == null) ? 0 : itemsOrdered.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (date_placed == null) {
			if (other.date_placed != null)
				return false;
		} else if (!date_placed.equals(other.date_placed))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemsOrdered == null) {
			if (other.itemsOrdered != null)
				return false;
		} else if (!itemsOrdered.equals(other.itemsOrdered))
			return false;
		return true;
	}

}
