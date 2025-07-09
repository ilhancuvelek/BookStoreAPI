package com.ilhancuvelek.bookstore.bookstore.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.BookService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.ErrorDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Book;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.User;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookCreateDTO;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	
	private BookService bookService;

	@Autowired
	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Book>> getAll(){
		return bookService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Book book) {
		return ResponseEntity.ok(bookService.add(book));
	}
	@PutMapping("/update")
	public Result update(@RequestBody Book book) {
		return bookService.update(book);
		
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody Book book) {
		return bookService.delete(book);
		
	}
	
	@GetMapping("/findByTitle")
	public DataResult<Book> findByTitle(@RequestParam String title) {
		return bookService.findByTitle(title);
	}

	@GetMapping("/findByPriceGreaterThan")
	public DataResult<List<Book>> findByPriceGreaterThan(@RequestParam double price) {
		return bookService.findByPriceGreaterThan(price);
	}

	@GetMapping("/findByStockGreaterThan")
	public DataResult<List<Book>> findByStockGreaterThan( @RequestParam int stock) {
		return bookService.findByStockGreaterThan(stock);
	}

	@GetMapping("/findByCategoryId")
	public DataResult<List<Book>> findByCategoryId(@RequestParam int categoryId) {
		return bookService.findByCategoryId(categoryId);
	}

	@GetMapping("/findByTitleAndCategory")
	public DataResult<Book> findByTitleAndCategory(@RequestParam String title,@RequestParam int categoryId) {
		return bookService.findByTitleAndCategory(title,categoryId);
	}

	@GetMapping("/findByBooksPriceRange")
	public DataResult<List<Book>> findByBooksPriceRange(@RequestParam double minPrice,@RequestParam double maxPrice) {
		return bookService.findByBooksPriceRange(minPrice,maxPrice);
	}

	@GetMapping("/findByTitleContains")
	public DataResult<List<Book>> findByTitleContains(@RequestParam String keyword) {
		return bookService.findByTitleContains(keyword);
	}

	@GetMapping("/findByTitleStartsWith")
	public DataResult<List<Book>> findByTitleStartsWith(@RequestParam String prefix) {
		return bookService.findByTitleStartsWith(prefix);
	}

	@GetMapping("/findByCategoryIdIn")
	public DataResult<List<Book>> findByCategoryIdIn(@RequestParam List<Integer> categoryIds) {
		return bookService.findByCategoryIdIn(categoryIds);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Book>> getAll(int pageNo, int pageSize) {
		return bookService.getAll(pageNo,pageSize);
	}

	@GetMapping("/getAllSorted")
	public DataResult<List<Book>> getAllSorted() {
		return bookService.getAllSorted();
	}
	@GetMapping("/getBookResponse")
	public DataResult<List<BookResponseDTO>> getBookResponse() {
		return bookService.getBookResponse();
	}
	
	@PostMapping("/addBookResponse")
	public ResponseEntity<?> add(@Valid @RequestBody BookCreateDTO bookCreateDTO) {
		return ResponseEntity.ok(bookService.addBookResponse(bookCreateDTO));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		
		return errors;
	}

}
