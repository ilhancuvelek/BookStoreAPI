package com.ilhancuvelek.bookstore.bookstore.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.OrderService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Order;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
	
	private OrderService orderService;
	
	@Autowired
	public OrdersController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Order>> getAll() {
		
		return orderService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestParam Order order) {
		return orderService.add(order);
		
	}
	
	@PutMapping("/update")
	public Result update(  @RequestParam Order order) {
		return orderService.update(order);
		
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam Order order) {
		return orderService.delete(order);
		
	}

	@GetMapping("/findByUserId")
	public DataResult<List<Order>> findByUserId(@RequestParam int userId) {
		return orderService.findByUserId(userId);
	}

	@GetMapping("/findOrdersWithTotalPriceGreaterThan")
	public DataResult<List<Order>> findOrdersWithTotalPriceGreaterThan(@RequestParam double amount) {
		return orderService.findOrdersWithTotalPriceGreaterThan(amount);
	}



}
