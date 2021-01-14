package com.qa.ims.persistence.dao;

public interface OrderUpdateDao<T> {
	
	T updateDelItem(T t);
	
	T updateAddItem(T t);
	
}
