package com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer>{

}
