package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.domain.Order;

public interface OrderCrudServices<T> {
	
	public List<T> readAll();
	
	T create(T t);
    
	Order updateDelItem(Order order, Long item_id);
	
	Order updateAddItem(Order order, Long item_id, Integer item_quantity);
 
    void delete(Long id);

}
