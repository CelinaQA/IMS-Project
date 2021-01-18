package com.qa.ims.persistence.domain;

import java.util.Calendar;
import java.util.Date;

public class Order {
	
	private Long id;
	private Long customer_id;
	private Date date_placed = Calendar.getInstance().getTime();
	private Float totalPrice;
	
	//Orderline
	private Long item_id;
	private Integer quantity;

	//to read
	public Order(Long id, Long customer_id, Date date_placed, Float totalPrice, Long item_id, Integer quantity) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.totalPrice = totalPrice;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	//to create order
	public Order(Long customer_id, Long item_id, Integer quantity) {
		super();
		this.customer_id = customer_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}
	
	//to update order
	public Order(Long id, Long customer_id, Float totalPrice, Long item_id, Integer quantity) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.totalPrice = totalPrice;
		this.item_id = item_id;
		this.quantity = quantity;
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
	
	//Getters and setters
	
	public Long getId() {
		return id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order ID = " + id + "\n"+ "Customer ID = " + customer_id + "\n"+"Date placed = " + date_placed + "\n"+
				"Total price: £" + totalPrice +"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((date_placed == null) ? 0 : date_placed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

}
