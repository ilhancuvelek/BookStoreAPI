package com.ilhancuvelek.bookstore.bookstore.business.abstracts;

import java.util.List;

import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.DataResult;
import com.ilhancuvelek.bookstore.bookstore.core.utilities.results.Result;
import com.ilhancuvelek.bookstore.bookstore.entities.concretes.Category;

public interface CategoryService {
	
	DataResult<List<Category>> getAll();
	
	DataResult<Category> getById(int categoryId);
	
	Result add(Category category);
	
	Result update(Category category);
	
	Result delete(Category category);

}
