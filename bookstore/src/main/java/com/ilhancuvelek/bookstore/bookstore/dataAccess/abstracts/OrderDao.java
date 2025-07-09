package com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

	List<Order> findByUserId(int userId);
	
	@Query("FROM Order WHERE totalPrice > :amount")
    List<Order> findOrdersWithTotalPriceGreaterThan(double amount);
}
