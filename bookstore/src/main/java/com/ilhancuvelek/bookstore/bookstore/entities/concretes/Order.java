package com.ilhancuvelek.bookstore.bookstore.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orderItems"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	@Column(name = "totalPrice")
    private double totalPrice;
	@Column(name = "createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
