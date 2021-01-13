package com.qa.ims.persistence.domain;

import java.util.Calendar;
import java.util.Date;

public class Order extends Customer{
	
	private Long id;
	private Long customer_id = super.getId();
	private Date date_placed = Calendar.getInstance().getTime();
	
	public Order(String firstName, String surname, Long id, Long customer_id) {
		super(firstName, surname);
		this.id = id;
		this.customer_id = customer_id;
	}
	
	public Order(String firstName, String surname, Long customer_id) {
		super(firstName, surname);
		this.customer_id = customer_id;
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
}
