package com.ilhancuvelek.bookstore.bookstore.business.abstracts;

import java.util.List;

import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.OrderItem;

public interface OrderItemService {
	
	DataResult<List<OrderItem>> getAll();
	Result add(OrderItem orderItem);

}
