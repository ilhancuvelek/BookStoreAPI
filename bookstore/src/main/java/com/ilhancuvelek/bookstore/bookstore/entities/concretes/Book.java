package com.ilhancuvelek.bookstore.bookstore.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "title")
    @NotBlank
    @NotNull
    private String title;
	
	@Column(name = "author")
    @NotBlank
    @NotNull
    private String author;
	
	@Column(name = "price")
    private double price;
	
	@Column(name = "stock")
    private int stock;
	
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
