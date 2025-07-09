package com.ilhancuvelek.bookstore.bookstore.business.abstracts;

import java.util.List;


import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Book;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookCreateDTO;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookResponseDTO;

public interface BookService {
	
	DataResult<List<Book>> getAll();
	
	DataResult<List<Book>> getAll(int pageNo,int pageSize);
	
	DataResult<List<Book>> getAllSorted();
	
	Result add(Book book);
	
	Result update(Book book);
	
	Result delete(Book book);
	
	DataResult<Book> findByTitle(String title);
	
	DataResult<List<Book>> findByPriceGreaterThan(double price);
	
	DataResult<List<Book>> findByStockGreaterThan(int stock);
	
	DataResult<List<Book>> findByCategoryId(int categoryId);

	DataResult<Book >findByTitleAndCategory(String title,int categoryId);

	DataResult<List<Book> >findByBooksPriceRange(double minPrice,double maxPrice);
	
	DataResult<List<Book>> findByTitleContains(String keyword);

	DataResult<List<Book> >findByTitleStartsWith(String prefix);
	
	DataResult<List<Book>> findByCategoryIdIn(List<Integer> categoryIds);
	
	DataResult<List<BookResponseDTO>> getBookResponse();
	
	Result addBookResponse(BookCreateDTO bookCreateDTO);

}
