package com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Book;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookResponseDTO;

public interface BookDao extends JpaRepository<Book, Integer>{
	
	Book findByTitle(String title);
	
	List<Book> findByPriceGreaterThan(double price);
	
	List<Book> findByStockGreaterThan(int stock);
	
	List<Book> findByCategoryId(int categoryId);
	
	@Query("From Book where title=:title and category.id=:categoryId")
	Book findByTitleAndCategory(String title,int categoryId);
	
	@Query("From Book where price between :minPrice and  :maxPrice")
	List<Book> findByBooksPriceRange(double minPrice,double maxPrice);
	
	List<Book> findByTitleContains(String keyword);

	List<Book> findByTitleStartsWith(String prefix);
	
	List<Book> findByCategoryIdIn(List<Integer> categoryIds);

	@Query("select "
			+ "new com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookResponseDTO(b.id,b.title,b.author,b.price,b.stock,c.description) "
			+ "from Category c inner join c.books b")
	List<BookResponseDTO> getBookResponse();
}
