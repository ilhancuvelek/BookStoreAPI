package com.ilhancuvelek.bookstore.bookstore.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDTO {
	
	@NotBlank
	@NotNull
    private String title;
	
	@NotBlank
	@NotNull
    private String author;
	
    private double price;
    private int stock;
    private int categoryId;
}
