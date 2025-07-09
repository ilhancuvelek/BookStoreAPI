package com.ilhancuvelek.bookstore.bookstore.business.abstracts;

import java.util.List;


import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Order;

public interface OrderService {
	
	DataResult<List<Order>> getAll();
	
	Result add(Order order);
	
	Result update(Order order);
	
	Result delete(Order order);
	
	DataResult<List<Order>> findByUserId(int userId);
	
	DataResult<List<Order>> findOrdersWithTotalPriceGreaterThan(double amount);

}
