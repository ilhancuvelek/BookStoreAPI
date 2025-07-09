package com.ilhancuvelek.bookstore.bookstore.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
	
    private int id;
    private String title;
    private String author;
    private double price;
    private int stock;
    private String categoryName;

}
