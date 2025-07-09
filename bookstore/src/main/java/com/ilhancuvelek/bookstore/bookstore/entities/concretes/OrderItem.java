package com.ilhancuvelek.bookstore.bookstore.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	@Column(name = "quantity")
    private int quantity;
	@Column(name = "unitPrice")
    private double unitPrice;
	
	@ManyToOne()
	@JoinColumn(name="order_id")
	private Order order;
	
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
