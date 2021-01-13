package com.qa.ims.persistence.domain;

import java.util.Calendar;
import java.util.Date;

public class Order {
	
	private Long id;
	private Long customer_id;
	private Date date_placed = Calendar.getInstance().getTime();
	
	public Order(Long id, Long customer_id, Date date_placed) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
	}

	public Order(Long id, Long customer_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
	}
	
	public Order(Long customer_id) {
		super();
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
