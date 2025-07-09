package com.ilhancuvelek.bookstore.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.OrderItemService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessResult;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.OrderItemDao;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.OrderItem;

@Service
public class OrderItemManager implements OrderItemService{
	
	private OrderItemDao orderItemDao;
	@Autowired
	public OrderItemManager(OrderItemDao orderItemDao) {
		super();
		this.orderItemDao = orderItemDao;
	}
	@Override
	public DataResult<List<OrderItem>> getAll() {
		
		return new SuccessDataResult<List<OrderItem>>(orderItemDao.findAll());
	}
	@Override
	public Result add(OrderItem orderItem) {
		orderItemDao.save(orderItem);
		return new SuccessResult();
	}

}
