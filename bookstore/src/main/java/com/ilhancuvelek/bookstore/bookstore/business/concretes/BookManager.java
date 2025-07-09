package com.ilhancuvelek.bookstore.bookstore.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ilhancuvelek.bookstore.bookstore.business.abstracts.BookService;
import com.ilhancuvelek.bookstore.bookstore.business.abstracts.CategoryService;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessDataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.SuccessResult;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.BookDao;
import com.ilhancuvelek.bookstore.bookstore.dataAccess.abstracts.CategoryDao;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Book;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Category;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookCreateDTO;
import com.ilhancuvelek.bookstore.bookstore.entities.dtos.BookResponseDTO;

@Service
public class BookManager implements BookService{
	
	private BookDao bookDao;
	
	private CategoryDao categoryDao;

	@Autowired
	public BookManager(BookDao bookDao, CategoryDao categoryDao) {
	    this.bookDao = bookDao;
	    this.categoryDao = categoryDao;
	}


	@Override
	public DataResult<List<Book>> getAll() {

		return new SuccessDataResult<List<Book>>(bookDao.findAll(),"Kitaplar Listelendi.");
	}

	@Override
	public Result add(Book book) {
		bookDao.save(book);
		return new SuccessResult("Kitap Eklendi");
	}

	@Override
	public DataResult<Book> findByTitle(String title) {
		return new SuccessDataResult<Book>(bookDao.findByTitle(title),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByPriceGreaterThan(double price) {
		return new SuccessDataResult<List<Book>>(bookDao.findByPriceGreaterThan(price),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByStockGreaterThan(int stock) {
		return new SuccessDataResult<List<Book>>(bookDao.findByStockGreaterThan(stock),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByCategoryId(int categoryId) {
		return new SuccessDataResult<List<Book>>(bookDao.findByCategoryId(categoryId),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<Book> findByTitleAndCategory(String title, int categoryId) {
		return new SuccessDataResult<Book>(bookDao.findByTitleAndCategory(title,categoryId),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByBooksPriceRange(double minPrice, double maxPrice) {
		return new SuccessDataResult<List<Book>>(bookDao.findByBooksPriceRange(minPrice,maxPrice),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByTitleContains(String keyword) {
		return new SuccessDataResult<List<Book>>(bookDao.findByTitleContains(keyword),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByTitleStartsWith(String prefix) {
		return new SuccessDataResult<List<Book>>(bookDao.findByTitleStartsWith(prefix),"Kitaplar Listelendi.");
	}

	@Override
	public DataResult<List<Book>> findByCategoryIdIn(List<Integer> categoryIds) {
		return new SuccessDataResult<List<Book>>(bookDao.findByCategoryIdIn(categoryIds),"Kitaplar Listelendi.");
	}

	@Override
	public Result update(Book book) {
		bookDao.save(book);
		return new SuccessResult("Güncellendi.");
	}

	@Override
	public Result delete(Book book) {
		bookDao.delete(book);
		return new SuccessResult("Silindi.");
	}

	@Override
	public DataResult<List<Book>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Book>>(bookDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Book>> getAllSorted() {
		Sort sort = Sort.by(Direction.DESC, "title");
		return new SuccessDataResult<List<Book>>(bookDao.findAll(sort));
	}

	@Override
	public DataResult<List<BookResponseDTO>> getBookResponse() {
		return new SuccessDataResult<List<BookResponseDTO>>(bookDao.getBookResponse());
	}

	@Override
	public Result addBookResponse(BookCreateDTO bookCreateDTO) {
	    Category category = categoryDao.findById(bookCreateDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
	    
	    Book book = new Book();
	    book.setTitle(bookCreateDTO.getTitle());
	    book.setAuthor(bookCreateDTO.getAuthor());
	    book.setPrice(bookCreateDTO.getPrice());
	    book.setStock(bookCreateDTO.getStock());
	    book.setCategory(category);
	    
	    bookDao.save(book);
	    
		return new SuccessResult("Eklendi");
	}

}
