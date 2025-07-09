package com.ilhancuvelek.bookstore.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.OrderService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessResult;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.OrderDao;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Order;

@Service
public class OrderManager implements OrderService{
	
	private OrderDao orderDao;

	@Autowired
	public OrderManager(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@Override
	public DataResult<List<Order>> getAll() {
		
		return new SuccessDataResult<List<Order>>(orderDao.findAll());
	}

	@Override
	public Result add(Order order) {
		orderDao.save(order);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Order>> findByUserId(int userId) {
		return new SuccessDataResult<List<Order>>(orderDao.findByUserId(userId));
	}

	@Override
	public DataResult<List<Order>> findOrdersWithTotalPriceGreaterThan(double amount) {
		return new SuccessDataResult<List<Order>>(orderDao.findOrdersWithTotalPriceGreaterThan(amount));
	}

	@Override
	public Result update(Order order) {
		orderDao.save(order);
		return new SuccessResult();
	}

	@Override
	public Result delete(Order order) {
		orderDao.delete(order);
		return new SuccessResult();
	}

}
