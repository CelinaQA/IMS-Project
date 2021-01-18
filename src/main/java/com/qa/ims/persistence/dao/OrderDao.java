package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qa.ims.persistence.domain.Order;

public interface OrderDao<T> {
	
	List<T> readAll();

	T create(T t);
	
	Order updateDelItem(Order order, Long item_id);
	
	Order updateAddItem(Order order, Long item_id, Integer item_quantity);
	
	void delete(long id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;
	
}
